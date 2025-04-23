package com.game.command.numbergame.infrastructure;

import org.springframework.stereotype.Component;

@Component
public class NumberValidator {

    public void validateNumberRange(int inputNumber, int answer) {
        if (inputNumber > answer) {
            throw new IllegalArgumentException("작습니다.");
        }

        if (inputNumber < answer) {
            throw new IllegalArgumentException("큽니다.");
        }
    }

}
