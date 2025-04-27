package com.game.query.dto;

import com.game.command.numbergame.domain.NumberStatistics;

public record NumberStatisticsResponse(
        int number,
        int frequency
) {

    public static NumberStatisticsResponse from(NumberStatistics numberStatistics) {
        return new NumberStatisticsResponse(numberStatistics.getNumber(), numberStatistics.getFrequency());
    }
}
