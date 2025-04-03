package com.game.common.log;

@FunctionalInterface
public interface ThrowableCallable<V> {

    V call() throws Throwable;
}
