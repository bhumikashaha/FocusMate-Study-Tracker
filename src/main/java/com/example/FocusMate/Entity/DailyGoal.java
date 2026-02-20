package com.example.FocusMate.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="daily_goal")
public class DailyGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dailyGoalId;

    private Long userId;

    private String goalText;

    private LocalDate goalDate;

    private Boolean completed = false;

    private Integer targetMinutes = 25;

    private Integer completedMinutes = 0;
    // getters & setters


    public Long getDailyGoalId() {
        return dailyGoalId;
    }

    public void setDailyGoalId(Long dailyGoalId) {
        this.dailyGoalId = dailyGoalId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGoalText() {
        return goalText;
    }

    public void setGoalText(String goalText) {
        this.goalText = goalText;
    }

    public LocalDate getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(LocalDate goalDate) {
        this.goalDate = goalDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getTargetMinutes() {
        return targetMinutes;
    }

    public void setTargetMinutes(Integer targetMinutes) {
        this.targetMinutes = targetMinutes;
    }

    public Integer getCompletedMinutes() {
        return completedMinutes;
    }

    public void setCompletedMinutes(Integer completedMinutes) {
        this.completedMinutes = completedMinutes;
    }
}
