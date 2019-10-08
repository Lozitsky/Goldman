package com.kirilo.game.interfaces.collections;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.objects.Coordinate;

import java.util.Collection;
import java.util.List;

public interface GameCollection {
    void addGameObject(AbstractGameObject gameObject);

    List<AbstractGameObject> getGameObjects(GameObjectType type);

    Collection<AbstractGameObject> getAllGameObjects();

    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);

    AbstractGameObject getObjectByCoordinate(int x, int y);
}
