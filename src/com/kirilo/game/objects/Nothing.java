package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.GameObjectType;

public class Nothing extends AbstractGameObject {
    public Nothing(Coordinate coordinate) {
        setType(GameObjectType.NOTHING);
        setCoordinate(coordinate);
        setIcon(getImageIcon(null));
    }
}
