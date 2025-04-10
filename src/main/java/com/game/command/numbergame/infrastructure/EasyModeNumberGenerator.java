package com.game.command.numbergame.infrastructure;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class EasyModeNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return ThreadLocalRandom.current().nextInt(1, 51);
    }

    @Override
    public String getLevel() {
        return "easy";
    }

}
