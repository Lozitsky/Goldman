package com.kirilo.game.objects.creators;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractObjectCreator;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.objects.*;

public class GameObjectCreator extends AbstractObjectCreator {


    @Override
    public AbstractGameObject createObject(Enum type, Object... objects) {
        AbstractGameObject object = null;
        switch ((GameObjectType)type) {
            case EXIT:
                object = new Exit((Coordinate) objects[0]);
                break;
            case WALL:
                object = new Wall((Coordinate) objects[0]);
                break;
            case GOLDMAN:
                object = new Goldman((Coordinate) objects[0]);
                break;
            case MONSTER:
                object = new Monster((Coordinate) objects[0]);
                break;
            case NOTHING:
                object = new Nothing((Coordinate) objects[0]);
                break;
            case TREASURE:
                object = new Treasure((Coordinate) objects[0]);
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
        return object;
    }

    public AbstractGameObject createObject(Enum type, Coordinate coordinate) {
        return this.createObject(type, (Object) coordinate);
    }

/*    public GameObjectCreator getSingleton() {
        Singleton<GameObjectCreator> instance = getInstance();
        return instance.getSingleton(getClass().getName());
    }*/

    @Override
    public GameObjectCreator getSingleton() {
        return (GameObjectCreator) super.getSingleton();
    }
}
