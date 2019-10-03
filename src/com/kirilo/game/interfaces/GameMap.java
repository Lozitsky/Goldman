package com.kirilo.game.interfaces;

public interface GameMap {
    int getHeight();

    int getWidth();

    int getTimeLimit();

    boolean loadMap();

    boolean saveMap();

    boolean drawMap();
}
