package com.game.command.numbergame.infrastructure;

import com.game.command.numbergame.exception.NumberGameException;
import com.game.common.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class NumberValidator {

    public void validateNumberRange(int inputNumber, int answer) {
        if (inputNumber > answer) {
            throw BusinessException.from(NumberGameException.TOO_SMALL);
        }

        if (inputNumber < answer) {
            throw BusinessException.from(NumberGameException.TOO_BIG);
        }
    }

}
