package com.kirilo.game.interfaces;


import com.kirilo.game.abstracts.AbstractGameMap;
import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.MovingDirection;

import javax.swing.*;

public interface MovingObject extends StaticObject {
    void getMoveResult(AbstractGameObject gameObjectWithNewCoordinate);

    void move(MovingDirection direction, AbstractGameMap abstractGameMap);

    void setIconLeft(ImageIcon iconLeft);

    void setIconRight(ImageIcon iconRight);

    void setIconUp(ImageIcon iconUp);

    void setIconDown(ImageIcon iconDown);

    ImageIcon getIconLeft();

    ImageIcon getIconRight();

    ImageIcon getIconUp();

    ImageIcon getIconDown();
}
