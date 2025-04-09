package com.game.command.record.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Record {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private int tryCount;
    private LocalDateTime elapsedTime;

    public static Record create(String nickname, int tryCount, LocalDateTime elapsedTime) {
        return new Record(nickname, tryCount, elapsedTime);
    }

    private Record(String nickname, int tryCount, LocalDateTime elapsedTime) {
        this.nickname = nickname;
        this.tryCount = tryCount;
        this.elapsedTime = elapsedTime;
    }

}
