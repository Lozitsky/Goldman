package com.kirilo.game.interfaces.maps;

import com.kirilo.game.abstracts.AbstractGameMap;

import java.awt.*;

public interface DrawableMap {
    Component getMap();

    AbstractGameMap getGameMap();

    boolean drawMap();
}
