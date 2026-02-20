package com.example.FocusMate.Service;

import com.example.FocusMate.Entity.Analytics;
import com.example.FocusMate.Repository.AnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final AnalyticsRepository repo;

    public Analytics getAnalytics(Long userId){
        return repo.findByUserId(userId).orElse(null);
    }
}
