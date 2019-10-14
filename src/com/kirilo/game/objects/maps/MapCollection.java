package com.kirilo.game.objects.maps;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.abstracts.MapListenersRecorder;
import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.listeners.MoveResultListener;
import com.kirilo.game.interfaces.movesrategies.MoveStrategy;
import com.kirilo.game.objects.*;

import java.util.*;

public class MapCollection extends MapListenersRecorder {
    public MapCollection() {
        addMoveListener(new WavPlayer());
    }

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);

    @Override
    public Collection<AbstractGameObject> getAllGameObjects() {
        return gameObjects.values();
    }

    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        AbstractGameObject gameObject = gameObjects.get(coordinate);
        if (gameObject == null) {
            gameObject = new Wall(coordinate);
        }
        return gameObject;
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }

    @Override
    public void moveObject(MovingDirection direction, GameObjectType objectType) {
        doMoveAction(direction, objectType, null);
    }

    @Override
    public void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType) {
        doMoveAction(null, gameObjectType, moveStrategy);
    }

    @Override
    public void addGameObject(AbstractGameObject gameObject) {
        gameObjects.put(gameObject.getCoordinate(), gameObject);
        ArrayList<AbstractGameObject> list = typeObjects.get(gameObject.getType());

        if (list == null) {
            list = new ArrayList<>();
        }

        list.add(gameObject);
        typeObjects.put(gameObject.getType(), list);
    }

    public void doMoveAction(MovingDirection direction, GameObjectType objectType, MoveStrategy moveStrategy) {
        ActionResult actionResult = null;
        Goldman goldman = (Goldman) getGameObjects(GameObjectType.GOLDMAN).get(0);

        for (AbstractGameObject gameObject : this.getGameObjects(objectType)) {
            if (gameObject instanceof AbstractMovingObject) {
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;

                if (direction == null) {
                    direction = moveStrategy.getDirection(movingObject, goldman, this);
                }

                Coordinate coordinate = movingObject.getDirectionCoordinate(direction);
                AbstractGameObject gameObjectWithNewCoordinate = getObjectByCoordinate(coordinate);

                actionResult = movingObject.moveToObject(direction, gameObjectWithNewCoordinate);

                switch (actionResult) {
                    case MOVE:
                        swapObjects(movingObject, gameObjectWithNewCoordinate);
                        break;
                    case COLLECT_TREASURE:
                        swapObjects(movingObject, new Nothing(coordinate));
                        break;
                    case WIN:
                    case DIE:
                        break;
                }
            }
        }

        notifyMoveListeners(actionResult, goldman);
    }

    private void swapObjects(AbstractGameObject object1, AbstractGameObject object2) {
        Coordinate coordinate1 = object1.getCoordinate();
        Coordinate coordinate2 = object2.getCoordinate();
        object1.setCoordinate(coordinate2);
        object2.setCoordinate(coordinate1);
        gameObjects.put(coordinate2, object1);
        gameObjects.put(coordinate1, object2);
    }

    @Override
    public void notifyMoveListeners(ActionResult result, Goldman goldman) {
        for (MoveResultListener listener : getMoveListeners()) {
            listener.notifyActionResult(result, goldman);
        }
    }
}
