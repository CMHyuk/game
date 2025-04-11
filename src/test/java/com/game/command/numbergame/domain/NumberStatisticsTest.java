package com.game.command.numbergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberStatisticsTest {

    @Test
    void 숫자를_증가시킨다() {
        // given
        int number = 20;
        int frequency = 1;

        NumberStatistics numberStatistics = new NumberStatistics(number, frequency);

        // when
        numberStatistics.increaseFrequency();

        // then
        Assertions.assertThat(numberStatistics.getFrequency()).isEqualTo(2);
    }

}