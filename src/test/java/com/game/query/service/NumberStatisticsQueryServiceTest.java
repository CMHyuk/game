package com.game.query.service;

import com.game.command.numbergame.domain.Level;
import com.game.command.numbergame.domain.NumberStatistics;
import com.game.command.numbergame.domain.NumberStatisticsRepository;
import com.game.query.dto.NumberStatisticsResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class NumberStatisticsQueryServiceTest {

    @Autowired
    private NumberStatisticsRepository numberStatisticsRepository;

    @Autowired
    private NumberStatisticsQueryService numberStatisticsQueryService;

    @ParameterizedTest
    @CsvSource({
            "easy, 1, 10",
            "normal, 2, 20",
            "hard, 3, 30"
    })
    void 난이도별로_등장한_숫자_통계를_조회한다(String level, int number, int frequency) {
        // given
        saveNumberStatistics(level, number, frequency);

        // when
        List<NumberStatisticsResponse> actual = numberStatisticsQueryService.findByLevel(level);

        // then
        assertThat(actual).hasSize(1);
        actual.forEach(response -> {
            assertThat(response.number()).isEqualTo(number);
            assertThat(response.frequency()).isEqualTo(frequency);
        });
    }

    private void saveNumberStatistics(String level, int number, int frequency) {
        NumberStatistics numberStatistics = new NumberStatistics(Level.from(level), number, frequency);
        numberStatisticsRepository.save(numberStatistics);
    }

}
