package com.game.command.numbergame.infrastructure;

import com.game.common.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum NumberGameException implements ErrorCode {

    NOT_EXISTS_PROVIDER(1001, 400, "해당 난이도는 제공하지 않습니다.")

    ;

    private final int value;
    private final int httpStatusCode;
    private final String message;
}
