package com.example.FocusMate.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="analytics")
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="analytics_id")
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="study_hours_month")
    private Integer studyHoursMonth;

    @Column(name="completed_goals")
    private Integer completedGoals;

    @Column(name="productivity_score")
    private Integer productivityScore;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

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

    public Integer getStudyHoursMonth() {
        return studyHoursMonth;
    }

    public void setStudyHoursMonth(Integer studyHoursMonth) {
        this.studyHoursMonth = studyHoursMonth;
    }

    public Integer getCompletedGoals() {
        return completedGoals;
    }

    public void setCompletedGoals(Integer completedGoals) {
        this.completedGoals = completedGoals;
    }

    public Integer getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(Integer productivityScore) {
        this.productivityScore = productivityScore;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
