package com.kirilo.game.objects.interfaces;


import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.objects.common.Coordinate;

import javax.swing.*;

public interface StaticObject {
    void setCoordinate(Coordinate coordinate);

    ImageIcon getIcon();

    GameObjectType getType();

    void setType(GameObjectType type);

    Coordinate getCoordinate();

    void setIcon(ImageIcon icon);
}
