package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.GameObjectType;

public class Wall extends AbstractGameObject {
    public Wall(Coordinate coordinate) {
        setType(GameObjectType.WALL);
        setCoordinate(coordinate);
        setIcon(getImageIcon("com/kirilo/game/images/wall.png"));
    }
}
