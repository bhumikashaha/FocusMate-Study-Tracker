package com.example.FocusMate.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="streak")
public class Streak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="streak_id")
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="current_streak")
    private Integer currentStreak;

    @Column(name="last_updated")
    private LocalDate lastUpdated;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(Integer currentStreak) {
        this.currentStreak = currentStreak;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
