package com.example.FocusMate.Service;

import com.example.FocusMate.Entity.Streak;
import com.example.FocusMate.Repository.StreakRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class StreakService {

    private final StreakRepository repo;

    public Streak getStreak(Long userId){
        return repo.findByUserId(userId).orElse(null);
    }

    public void updateStreak(Long userId){
        Streak streak = getStreak(userId);
        LocalDate today = LocalDate.now();

        if(streak == null){
            streak = new Streak();
            streak.setUserId(userId);
            streak.setCurrentStreak(1);
            streak.setLastUpdated(today);
        } else if(streak.getLastUpdated().isEqual(today.minusDays(1))){
            streak.setCurrentStreak(streak.getCurrentStreak() + 1);
            streak.setLastUpdated(today);
        } else if(!streak.getLastUpdated().isEqual(today)){
            streak.setCurrentStreak(1);
            streak.setLastUpdated(today);
        }

        repo.save(streak);
    }
}
