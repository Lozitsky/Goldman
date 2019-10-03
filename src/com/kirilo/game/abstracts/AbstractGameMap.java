package com.kirilo.game.abstracts;

import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.interfaces.GameMap;
import com.kirilo.game.objects.Coordinate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

public class AbstractGameMap implements GameMap, Serializable {
    private static final long serialVersionUID = -6588926659509137481L;
    private int width;
    private int height;
    private int timeLimit;
    private boolean isExitExist;
    private boolean isGoldManExist;
    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    @Override
    public boolean loadMap() {
        return false;
    }

    @Override
    public boolean saveMap() {
        return false;
    }

    @Override
    public boolean drawMap() {
        return false;
    }

    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject) {
        return firstObject.getType().getPriority() > secondObject.getType().getPriority() ? firstObject : secondObject;
    }

    public boolean isValidMap() {
        return isExitExist && isGoldManExist;
    }

    public List<AbstractGameObject> getObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }

    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }
}
