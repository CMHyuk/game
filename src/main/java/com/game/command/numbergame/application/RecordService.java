package com.game.command.numbergame.application;

import com.game.command.numbergame.domain.Record;
import com.game.command.numbergame.domain.RecordRepository;
import com.game.command.numbergame.dto.GameResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    public void save(GameResult gameResult) {
        Record record = gameResult.toEntity();
        recordRepository.save(record);
    }

}
