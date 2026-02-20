package com.example.FocusMate.Repository;

import com.example.FocusMate.Entity.SessionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SessionRecordRepository extends JpaRepository<SessionRecord, Long> {
    List<SessionRecord> findByUserId(Long userId);
    List<SessionRecord> findByUserIdAndStartTimeBetween(Long userId, LocalDate start, LocalDate end);
}
