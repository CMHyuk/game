package com.game.common.log;

@FunctionalInterface
public interface ThrowableRunnable {

    void run() throws Throwable;
}
