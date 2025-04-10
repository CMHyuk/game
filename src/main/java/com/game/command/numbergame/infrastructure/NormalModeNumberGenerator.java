package com.game.command.numbergame.infrastructure;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class NormalModeNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return ThreadLocalRandom.current().nextInt(1, 101);
    }

    @Override
    public String getLevel() {
        return "normal";
    }

}
