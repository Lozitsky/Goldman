package com.kirilo.game.objects.common;

import com.kirilo.game.objects.interfaces.MovingObject;

import javax.swing.*;

public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {
    private ImageIcon iconLeft;
    private ImageIcon iconRight;
    private ImageIcon iconUp;
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
