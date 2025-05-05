package com.game.query.service;

import com.game.command.numbergame.domain.Record;
import com.game.query.dto.RecordResponse;
import com.game.query.repository.RecordQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordQueryService {

    private final RecordQueryRepository recordQueryRepository;

    public List<RecordResponse> findByLevel(String level) {
        List<Record> records = recordQueryRepository.findByLevel(level);
        return records.stream()
                .map(record -> new RecordResponse(record.getAttemptCount(), record.getElapsedTime()))
                .toList();
    }

}
