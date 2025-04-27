package com.game.command.numbergame.domain;

import com.game.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NumberStatistics extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Level level;
    private int number;
    private int frequency;

    public NumberStatistics(Level level, int number, int frequency) {
        this.level = level;
        this.number = number;
        this.frequency = frequency;
    }

    public void increaseFrequency() {
        this.frequency++;
    }

}
