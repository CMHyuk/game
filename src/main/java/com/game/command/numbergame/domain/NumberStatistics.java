package com.game.command.numbergame.domain;

import com.game.common.entity.BaseEntity;
import com.game.common.exception.BusinessException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.game.command.numbergame.exception.NumberGameException.INVALID_NUMBER_RANGE;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NumberStatistics extends BaseEntity {

    public static final int MIN = 1;
    private static final int EASY_MAX_NUM = 50;
    private static final int NORMAL_MAX_NUM = 100;
    private static final int HARD_MAX_NUM = 1000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Level level;
    private int number;
    private int frequency;

    public NumberStatistics(Level level, int number, int frequency) {
        validateNumberRange(level, number);
        this.level = level;
        this.number = number;
        this.frequency = frequency;
    }

    public void increaseFrequency() {
        this.frequency++;
    }

    private void validateNumberRange(Level level, int number) {
        int max = switch (level) {
            case EASY -> EASY_MAX_NUM;
            case NORMAL -> NORMAL_MAX_NUM;
            case HARD -> HARD_MAX_NUM;
        };

        if (number < MIN || number > max) {
            throw BusinessException.from(INVALID_NUMBER_RANGE);
        }
    }

}
