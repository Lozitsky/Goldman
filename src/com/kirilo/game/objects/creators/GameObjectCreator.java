package com.kirilo.game.objects.creators;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractObjectCreator;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.objects.*;

public class GameObjectCreator extends AbstractObjectCreator {


    @Override
    public AbstractGameObject createObject(Enum type, Coordinate... coordinates) {
        AbstractGameObject object = null;
        switch ((GameObjectType)type) {
            case EXIT:
                object = new Exit(coordinates[0]);
                break;
            case WALL:
                object = new Wall(coordinates[0]);
                break;
            case GOLDMAN:
                object = new Goldman(coordinates[0]);
                break;
            case MONSTER:
                object = new Monster(coordinates[0]);
                break;
            case NOTHING:
                object = new Nothing(coordinates[0]);
                break;
            case TREASURE:
                object = new Treasure(coordinates[0]);
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
        return object;
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
