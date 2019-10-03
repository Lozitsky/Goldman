package com.kirilo.game.abstracts;

import com.kirilo.game.interfaces.MovingObject;

import javax.swing.*;

public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {
    private ImageIcon iconLeft;
    private ImageIcon iconRight;
    private ImageIcon iconUp;

    public void setIconLeft(ImageIcon iconLeft) {
        this.iconLeft = iconLeft;
    }

    public void setIconRight(ImageIcon iconRight) {
        this.iconRight = iconRight;
    }

    public void setIconUp(ImageIcon iconUp) {
        this.iconUp = iconUp;
    }

    public void setIconDown(ImageIcon iconDown) {
        this.iconDown = iconDown;
    }

    private ImageIcon iconDown;

    @Override
    public ImageIcon getIconLeft() {
        return iconLeft;
    }

    @Override
    public ImageIcon getIconRight() {
        return iconRight;
    }

    @Override
    public ImageIcon getIconUp() {
        return iconUp;
    }

    @Override
    public ImageIcon getIconDown() {
        return iconDown;
    }
}
