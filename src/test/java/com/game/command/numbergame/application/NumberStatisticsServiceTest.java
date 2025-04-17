package com.game.command.numbergame.application;

import com.game.command.numbergame.domain.NumberStatistics;
import com.game.command.numbergame.domain.NumberStatisticsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class NumberStatisticsServiceTest {

    @Autowired
    private NumberStatisticsRepository numberStatisticsRepository;

    @Autowired
    private NumberStatisticsService numberStatisticsService;

    @Nested
    @DisplayName("숫자를 저장할 때")
    class NumberStatisticsSaveTest {

        @Test
        void 이미_존재하는_숫자는_빈도수를_증가시킨다() {
            // given
            int number = 20;
            NumberStatistics numberStatistics = new NumberStatistics(number, 1);
            numberStatisticsRepository.save(numberStatistics);

            // when
            numberStatisticsService.save(number);

            // then
            NumberStatistics result = numberStatisticsRepository.findByNumber(number)
                    .orElseThrow(IllegalArgumentException::new);

            Assertions.assertThat(result.getFrequency()).isEqualTo(2);
        }

        @Test
        void 존재하지_않는_숫자는_빈도수를_1로_저장한다() {
            // given
            int number = 20;

            // when
            numberStatisticsService.save(number);

            // then
            NumberStatistics result = numberStatisticsRepository.findByNumber(number)
                    .orElseThrow(IllegalArgumentException::new);

            Assertions.assertThat(result.getFrequency()).isEqualTo(1);
        }
    }

}
