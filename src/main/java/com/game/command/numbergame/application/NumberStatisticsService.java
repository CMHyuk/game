package com.game.command.numbergame.application;

import com.game.command.numbergame.domain.Level;
import com.game.command.numbergame.domain.NumberStatistics;
import com.game.command.numbergame.domain.NumberStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NumberStatisticsService {

    private final NumberStatisticsRepository numberStatisticsRepository;

    public void save(String level, int number) {
        numberStatisticsRepository.findByLevelAndNumber(Level.from(level), number)
                .ifPresentOrElse(
                        NumberStatistics::increaseFrequency,
                        () -> {
                            NumberStatistics numberStatistics = new NumberStatistics(Level.from(level), number, 1);
                            numberStatisticsRepository.save(numberStatistics);
                        }
                );
    }

}
