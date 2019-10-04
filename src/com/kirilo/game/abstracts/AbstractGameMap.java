package com.kirilo.game.abstracts;

import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.interfaces.GameMap;
import com.kirilo.game.objects.Coordinate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractGameMap implements GameMap, Serializable {
    private static final long serialVersionUID = -6588926659509137481L;
    private int width;
    private long height;
    private int timeLimit;
    private String name;
    private boolean isExitExist;
    private boolean isGoldManExist;
    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);

    public void addGameObject(AbstractGameObject gameObject) {
        gameObjects.put(gameObject.getCoordinate(), gameObject);
        ArrayList<AbstractGameObject> list = typeObjects.get(gameObject.getType());

        if (list == null) {
            list = new ArrayList<>();
        }

        list.add(gameObject);
        typeObjects.put(gameObject.getType(), list);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExitExist() {
        return isExitExist;
    }

    public void setExitExist(boolean exitExist) {
        isExitExist = exitExist;
    }

    public boolean isGoldManExist() {
        return isGoldManExist;
    }

    public void setGoldManExist(boolean goldManExist) {
        isGoldManExist = goldManExist;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    @Override
    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
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
