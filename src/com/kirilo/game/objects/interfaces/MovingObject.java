package com.kirilo.game.objects.interfaces;


import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.objects.common.AbstractGameObject;

import javax.swing.*;

public interface MovingObject extends StaticObject {
    void getMoveResult(AbstractGameObject gameObjectWithNewCoordinate);

    void move(MovingDirection direction);

    ImageIcon getIconLeft();

    ImageIcon getIconRight();

    ImageIcon getIconUp();

    ImageIcon getIconDown();
}
