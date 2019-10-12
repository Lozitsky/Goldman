package com.kirilo.game.interfaces.collections;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.listeners.MoveResultNotifier;
import com.kirilo.game.objects.Coordinate;

import java.util.Collection;
import java.util.List;

public interface GameCollection extends MoveResultNotifier {
    void addGameObject(AbstractGameObject gameObject);

    List<AbstractGameObject> getGameObjects(GameObjectType type);

    Collection<AbstractGameObject> getAllGameObjects();

    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);

    AbstractGameObject getObjectByCoordinate(int x, int y);

    void moveObject(MovingDirection direction, GameObjectType objectType);

    void moveObjectRandom(GameObjectType objectType);
}
