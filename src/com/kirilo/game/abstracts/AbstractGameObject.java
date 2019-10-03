package com.kirilo.game.abstracts;

import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.interfaces.StaticObject;
import com.kirilo.game.objects.Coordinate;

import javax.swing.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractGameObject)) return false;
        AbstractGameObject that = (AbstractGameObject) o;
        return type == that.type &&
                coordinate.equals(that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, coordinate);
    }

    @Override
    public String toString() {
        return "AbstractGameObject{" +
                "type=" + type +
                ", coordinate=" + coordinate +
                '}';
    }
}
