package com.game.command.numbergame.infrastructure;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class EasyModeNumberGenerator implements NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 50;

    @Override
    public int generateNumber() {
        return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }

    @Override
    public String getLevel() {
        return "easy";
    }

}
