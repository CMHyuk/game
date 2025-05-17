package com.game.command.numbergame.exception;

import com.game.common.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum NumberGameException implements ErrorCode {

    NOT_EXISTS_PROVIDER(1001, 400, "해당 난이도는 제공하지 않습니다."),
    TOO_BIG(1002, 400, "입력 숫자보다 큽니다."),
    TOO_SMALL(1003, 400, "입력 숫자보다 작습니다."),
    INVALID_NUMBER_RANGE(1004, 400, "난이도에 맞지 않는 숫자 범위입니다.")

    ;

    private final int value;
    private final int httpStatusCode;
    private final String message;
}
