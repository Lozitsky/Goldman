package com.kirilo.game.interfaces;

import com.kirilo.game.objects.Coordinate;

public interface Creator<T> {
    T createObject(Enum type, Coordinate... coordinates);
}
