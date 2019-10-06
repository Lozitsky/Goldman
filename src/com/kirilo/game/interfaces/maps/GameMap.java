package com.kirilo.game.interfaces.maps;

public interface GameMap {
    int getHeight();

    int getWidth();

    int getTimeLimit();

    boolean loadMap(Object source);

    boolean saveMap(Object source);

}
