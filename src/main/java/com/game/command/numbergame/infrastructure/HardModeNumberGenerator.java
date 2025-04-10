package com.game.command.numbergame.infrastructure;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class HardModeNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return ThreadLocalRandom.current().nextInt(1, 1001);
    }

    @Override
    public String getLevel() {
        return "hard";
    }

}
