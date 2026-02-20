package com.example.FocusMate.Service;

import com.example.FocusMate.Entity.DailyGoal;
import com.example.FocusMate.Repository.DailyGoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DailyGoalService {

    private final DailyGoalRepository goalRepository;

    // 🔹 Get today's goal
    public DailyGoal getTodayGoals(Long userId) {
        return goalRepository
                .findByUserIdAndGoalDate(userId, LocalDate.now())
                .orElse(null);
    }

    // 🔹 Save / Update goal
    public void setGoal(Long userId, String goalText) {

        DailyGoal goal = goalRepository
                .findByUserIdAndGoalDate(userId, LocalDate.now())
                .orElse(new DailyGoal());

        goal.setUserId(userId);
        goal.setGoalText(goalText);
        goal.setGoalDate(LocalDate.now());
        goal.setCompleted(false);

        goalRepository.save(goal);
    }

    // 🔹 Mark completed
    public void markCompleted(Long userId) {
        goalRepository
                .findByUserIdAndGoalDate(userId, LocalDate.now())
                .ifPresent(goal -> {
                    goal.setCompleted(true);
                    goalRepository.save(goal);
                });
    }

    // 🔹 Add focus minutes (called from Pomodoro)
    public void addFocusMinutes(Long userId, int minutes) {

        DailyGoal goal = goalRepository
                .findByUserIdAndGoalDate(userId, LocalDate.now())
                .orElse(null);

        if (goal == null) return;

        goal.setCompletedMinutes(goal.getCompletedMinutes() + minutes);

        if (goal.getCompletedMinutes() >= goal.getTargetMinutes()) {
            goal.setCompleted(true);
        }

        goalRepository.save(goal);
    }
}

