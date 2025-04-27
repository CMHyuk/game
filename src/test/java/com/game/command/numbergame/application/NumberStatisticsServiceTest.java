package com.game.command.numbergame.application;

import com.game.command.numbergame.domain.Level;
import com.game.command.numbergame.domain.NumberStatistics;
import com.game.command.numbergame.domain.NumberStatisticsRepository;
import com.game.command.numbergame.exception.NumberGameException;
import com.game.common.exception.BusinessException;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class NumberStatisticsServiceTest {

    @Autowired
    private NumberStatisticsRepository numberStatisticsRepository;

    @Autowired
    private NumberStatisticsService numberStatisticsService;

    private static final int NUMBER = 1;

    @Nested
    @DisplayName("숫자를 저장할 때")
    class NumberStatisticsSaveTest {

        @Test
        void 해당_난이도에_이미_존재하는_숫자는_빈도수를_증가시킨다() {
            // given
            String level = "easy";
            NumberStatistics numberStatistics = new NumberStatistics(Level.from(level), NUMBER, 1);
            numberStatisticsRepository.save(numberStatistics);

            // when
            numberStatisticsService.save(level, NUMBER);

            // then
            NumberStatistics result = numberStatisticsRepository.findByLevelAndNumber(Level.from(level), NUMBER)
                    .orElseThrow(IllegalArgumentException::new);

            Assertions.assertThat(result.getFrequency()).isEqualTo(2);
        }

        @Test
        void 존재하지_않는_숫자는_빈도수를_1로_저장한다() {
            // given
            String level = "easy";

            // when
            numberStatisticsService.save(level, NUMBER);

            // then
            NumberStatistics result = numberStatisticsRepository.findByLevelAndNumber(Level.from(level), NUMBER)
                    .orElseThrow(EntityNotFoundException::new);

            Assertions.assertThat(result.getFrequency()).isEqualTo(1);
        }

        @Test
        void 존재하지_않는_난이도는_예외가_발생한다() {
            // given
            String level = "not-existed-level";

            // when then
            assertThatThrownBy(() -> numberStatisticsService.save(level, NUMBER))
                    .isInstanceOf(BusinessException.class)
                    .extracting("errorCode")
                    .isEqualTo(NumberGameException.NOT_EXISTS_PROVIDER);
        }
    }

}
