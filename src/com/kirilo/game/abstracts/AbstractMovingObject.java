package com.kirilo.game.abstracts;

import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.MovingObject;
import com.kirilo.game.objects.Coordinate;

import javax.swing.*;

public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {
    private ImageIcon iconLeft;
    private ImageIcon iconRight;
    private ImageIcon iconUp;
    private ImageIcon iconDown;

    @Override
    public void move(MovingDirection direction, AbstractGameMap abstractGameMap) {
        int x = getCoordinate().getX();
        int y = getCoordinate().getY();

        Coordinate coordinate = new Coordinate(x, y);

        switch (direction) {
            case UP:
                setIcon(getIconUp());
                coordinate.setCoordinate(x, --y);
                break;
            case DOWN:
                setIcon(getIconDown());
                coordinate.setCoordinate(x, ++y);
                break;
            case LEFT:
                setIcon(getIconLeft());
                coordinate.setCoordinate(--x, y);
                break;
            case RIGHT:
                setIcon(getIconRight());
                coordinate.setCoordinate(++x, y);
                break;
        }

        setCoordinate(coordinate);
    }

    @Override
    public ImageIcon getIconLeft() {
        return iconLeft;
    }

    @Override
    public void setIconLeft(ImageIcon iconLeft) {
        this.iconLeft = iconLeft;
    }

    @Override
    public ImageIcon getIconRight() {
        return iconRight;
    }

    @Override
    public void setIconRight(ImageIcon iconRight) {
        this.iconRight = iconRight;
    }

    @Override
    public ImageIcon getIconUp() {
        return iconUp;
    }

    @Override
    public void setIconUp(ImageIcon iconUp) {
        this.iconUp = iconUp;
    }

    @Override
    public ImageIcon getIconDown() {
        return iconDown;
    }

    @Override
    public void setIconDown(ImageIcon iconDown) {
        this.iconDown = iconDown;
    }
}
