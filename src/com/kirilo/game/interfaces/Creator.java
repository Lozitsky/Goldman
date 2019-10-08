package com.kirilo.game.interfaces;


public interface Creator<T> {
    T createObject(Enum type, Object... objects);
}
