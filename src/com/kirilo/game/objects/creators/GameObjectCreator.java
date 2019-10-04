package com.kirilo.game.objects.creators;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.objects.*;

public class GameObjectCreator {
    private static GameObjectCreator creators;

    public static GameObjectCreator getInstance() {
        if (creators == null) {
            creators = new GameObjectCreator();
        }
        return creators;
    }


    public AbstractGameObject createObject(GameObjectType type, Coordinate coordinate) {
        AbstractGameObject object = null;
        switch (type) {
            case EXIT:
                object = new Exit(coordinate);
                break;
            case WALL:
                object = new Wall(coordinate);
                break;
            case GOLDMAN:
                object = new Goldman(coordinate);
                break;
            case MONSTER:
                object = new Monster(coordinate);
                break;
            case NOTHING:
                object = new Nothing(coordinate);
                break;
            case TREASURE:
                object = new Treasure(coordinate);
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
        return object;
    }
}
