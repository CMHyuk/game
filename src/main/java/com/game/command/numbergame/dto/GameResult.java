package com.game.command.numbergame.dto;

import com.game.command.numbergame.domain.Record;

public record GameResult(
        String level,
        int attemptCount,
        String elapsedTime
) {

    public Record toEntity() {
        return Record.create(level, attemptCount, Double.parseDouble(elapsedTime));
    }
}
