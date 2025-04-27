package com.game.query.service;

import com.game.command.numbergame.domain.Level;
import com.game.command.numbergame.domain.NumberStatistics;
import com.game.query.dto.NumberStatisticsResponse;
import com.game.query.repository.NumberStatisticsQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NumberStatisticsQueryService {

    private final NumberStatisticsQueryRepository numberStatisticsQueryRepository;

    public List<NumberStatisticsResponse> findByLevel(String level) {
        List<NumberStatistics> numberStatistics = numberStatisticsQueryRepository.findByLevel(Level.from(level));
        return numberStatistics.stream()
                .map(NumberStatisticsResponse::from)
                .toList();
    }

}
