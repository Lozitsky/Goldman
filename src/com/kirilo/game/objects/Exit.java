package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.GameObjectType;

public class Exit extends AbstractGameObject {
    public Exit(Coordinate coordinate) {
        setType(GameObjectType.EXIT);
        setCoordinate(coordinate);
        setIcon(getImageIcon("/com/kirilo/game/images/exit.gif"));
    }
}
