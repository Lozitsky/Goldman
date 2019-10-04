package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;

public class Monster extends AbstractMovingObject {

    public Monster(Coordinate coordinate) {
        setType(GameObjectType.MONSTER);
        setCoordinate(coordinate);
        setIconUp(getImageIcon("com/kirilo/game/images/monster_up.jpg"));
        setIconDown(getImageIcon("com/kirilo/game/images/monster_down.jpg"));
        setIconLeft(getImageIcon("com/kirilo/game/images/monster_left.jpg"));
        setIconRight(getImageIcon("com/kirilo/game/images/monster_right.jpg"));
        setIcon(getIconUp());
    }

    @Override
    public void getMoveResult(AbstractGameObject gameObjectWithNewCoordinate) {

    }

    @Override
    public void move(MovingDirection direction) {

    }
}
