package com.kirilo.game.abstracts;

import com.kirilo.game.interfaces.collections.GameCollection;
import com.kirilo.game.interfaces.maps.GameMap;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractGameMap implements GameMap, Serializable {
    private static final long serialVersionUID = -6588926659509137481L;
    private GameCollection gameCollection;
    private int width;
    private int height;
    private int timeLimit;
    private String name;
    private boolean isExitExist;
    private boolean isGoldManExist;

    public AbstractGameMap() {
    }

    public AbstractGameMap(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

    public boolean isExitExist() {
        return isExitExist;
    }

    public void setExitExist(boolean isExitExist) {
        this.isExitExist = isExitExist;
    }

    public boolean isGoldManExist() {
        return isGoldManExist;
    }

    public void setGoldManExist(boolean goldManExist) {
        isGoldManExist = goldManExist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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

    public GameCollection getGameCollection() {
        if (gameCollection == null) {
            try {
                throw new Exception("Game collection not initialized!");
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
        }
        return gameCollection;
    }

    public void setGameCollection(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

/*    public ActionResult move(MovingDirection direction, GameObjectType gameObjectType) {
        return getGameCollection().moveObject(direction, gameObjectType);
*//*        for (AbstractGameObject gameObject : getGameCollection().getGameObjects(gameObjectType)) {
            if (gameObject instanceof AbstractMovingObject) {
                ((AbstractMovingObject) gameObject).move(direction, this);
            }
        }*//*
    }*/
}
