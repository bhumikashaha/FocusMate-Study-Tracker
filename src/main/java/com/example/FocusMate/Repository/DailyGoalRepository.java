package com.example.FocusMate.Repository;

import com.example.FocusMate.Entity.DailyGoal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DailyGoalRepository
        extends JpaRepository<DailyGoal, Long> {

    Optional<DailyGoal> findByUserIdAndGoalDate(
            Long userId,
            LocalDate goalDate
    );
}
