package com.game.common.exception;

public interface ErrorCode {

    int getValue();

    int getHttpStatusCode();

    String getMessage();
}
