package com.kirilo.game.interfaces;


import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.enums.MovingDirection;

public interface MovingObject extends StaticObject {
//    void getMoveResult(AbstractGameObject gameObjectWithNewCoordinate);

    ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject);

    int getStep();

/*    void setIconLeft(ImageIcon iconLeft);

    void setIconRight(ImageIcon iconRight);

    void setIconUp(ImageIcon iconUp);

    void setIconDown(ImageIcon iconDown);

    ImageIcon getIconLeft();

    ImageIcon getIconRight();

    ImageIcon getIconUp();

    ImageIcon getIconDown();*/
}
