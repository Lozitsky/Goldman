package com.kirilo.game.objects.common;

import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.objects.interfaces.StaticObject;

import javax.swing.*;

public abstract class AbstractGameObject implements StaticObject {
    private GameObjectType type;
    private Coordinate coordinate;
    private ImageIcon icon = getImageIcon("/com/kirilo/game/images/noicon.png");


    protected ImageIcon getImageIcon(String path) {
        return new ImageIcon(getClass().getResource(path));
    }

    @Override
    public GameObjectType getType() {

        return type;
    }

    @Override
    public void setType(GameObjectType type) {
        this.type = type;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    @Override
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
