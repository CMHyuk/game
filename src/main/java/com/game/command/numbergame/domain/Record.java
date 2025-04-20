package com.game.command.numbergame.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Record {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level;
    private int attemptCount;
    private double elapsedTime;

    public static Record create(String level, int attemptCount, double elapsedTime) {
        return new Record(level, attemptCount, elapsedTime);
    }

    private Record(String level, int attemptCount, double elapsedTime) {
        this.level = level;
        this.attemptCount = attemptCount;
        this.elapsedTime = elapsedTime;
    }

}
