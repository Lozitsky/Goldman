package com.kirilo.game.interfaces;

public interface GameMap {
    long getHeight();

    int getWidth();

    int getTimeLimit();

    boolean loadMap(Object source);

    boolean saveMap(Object source);

    boolean drawMap();
}
