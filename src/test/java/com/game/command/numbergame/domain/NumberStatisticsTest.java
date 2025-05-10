package com.game.command.numbergame.domain;

import com.game.common.exception.BusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.game.command.numbergame.exception.NumberGameException.INVALID_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberStatisticsTest {

    @Test
    void 숫자를_증가시킨다() {
        // given
        String level = "easy";
        int number = 20;
        int frequency = 1;

        NumberStatistics numberStatistics = new NumberStatistics(Level.from(level), number, frequency);

        // when
        numberStatistics.increaseFrequency();

        // then
        Assertions.assertThat(numberStatistics.getFrequency()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({
            "easy, 1, 10",
            "normal, 2, 20",
            "hard, 3, 30"
    })
    void 난이도와_숫자가_유효하면_정상적으로_생성된다(String level, int number, int frequency) {
        // when & then
        NumberStatistics result = new NumberStatistics(Level.from(level), number, frequency);
        Assertions.assertThat(result.getLevel()).isEqualTo(Level.from(level));
        Assertions.assertThat(result.getNumber()).isEqualTo(number);
        Assertions.assertThat(result.getFrequency()).isEqualTo(frequency);
    }

    @ParameterizedTest
    @CsvSource({
            "easy, 0",
            "easy, 51",
            "normal, 0",
            "normal, 101",
            "hard, 0",
            "hard, 1001"
    })
    void 난이도별_숫자범위_초과시_예외가_발생한다(String level, int number) {
        // when & then
        assertThatThrownBy(() -> new NumberStatistics(Level.from(level), number, 1))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(INVALID_NUMBER_RANGE.getMessage());
    }

}
