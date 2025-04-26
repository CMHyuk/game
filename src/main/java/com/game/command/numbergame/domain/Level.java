package com.game.command.numbergame.domain;


import com.game.common.exception.BusinessException;
import lombok.Getter;

import java.util.Arrays;

import static com.game.command.numbergame.exception.NumberGameException.NOT_EXISTS_PROVIDER;

@Getter
public enum Level {
    EASY("easy"), NORMAL("normal"), HARD("hard");

    private final String level;

    Level(String value) {
        this.level = value;
    }

    public static Level from(String level) {
        return Arrays.stream(Level.values())
                .filter(l -> l.getLevel().equalsIgnoreCase(level))
                .findFirst()
                .orElseThrow(() -> BusinessException.from(NOT_EXISTS_PROVIDER));
    }

}
