package com.kirilo.game.interfaces;


import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.MovingDirection;

import javax.swing.*;

public interface MovingObject extends StaticObject {
    void getMoveResult(AbstractGameObject gameObjectWithNewCoordinate);

    void move(MovingDirection direction);

    ImageIcon getIconLeft();

    ImageIcon getIconRight();

    ImageIcon getIconUp();

    ImageIcon getIconDown();
}
