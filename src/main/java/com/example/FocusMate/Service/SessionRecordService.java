package com.example.FocusMate.Service;

import com.example.FocusMate.Entity.SessionRecord;
import com.example.FocusMate.Entity.User;
import com.example.FocusMate.Repository.SessionRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionRecordService {

    private final SessionRecordRepository repo;

    public void saveSession(SessionRecord record){
        repo.save(record);
    }

    public void saveSession(User user, int minutes){
        SessionRecord rec = new SessionRecord();
        rec.setUserId(user.getUserId());
        rec.setStartTime(LocalDateTime.now());
        rec.setEndTime(LocalDateTime.now().plusMinutes(minutes));
        rec.setTotalMinutes(minutes);
        repo.save(rec);
    }

    public List<SessionRecord> getAllSessions(Long userId){
        return repo.findByUserId(userId);
    }
}
