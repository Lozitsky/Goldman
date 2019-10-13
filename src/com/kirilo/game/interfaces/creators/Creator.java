package com.kirilo.game.interfaces.creators;


public interface Creator<T> {
    T createObject(Enum type, Object... objects);
}
