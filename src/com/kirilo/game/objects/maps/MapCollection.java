package com.kirilo.game.objects.maps;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.abstracts.MapListenersRecorder;
import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.listeners.MoveResultListener;
import com.kirilo.game.objects.Coordinate;
import com.kirilo.game.objects.Goldman;
import com.kirilo.game.objects.Nothing;

import java.util.*;

public class MapCollection extends MapListenersRecorder {
    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);

    @Override
    public Collection<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values());
    }

    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
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

    @Override
    public void moveObject(MovingDirection direction, GameObjectType objectType) {
        ActionResult actionResult = null;
        for (AbstractGameObject gameObject : this.getGameObjects(objectType)) {
            if (gameObject instanceof AbstractMovingObject) {
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;

                if (direction == null) {
                    direction = getRandomMoveDirection(movingObject);
                }

                Coordinate coordinate = getNewCoordinate(direction, movingObject);
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

        notifyMoveListeners(actionResult, (Goldman) getGameObjects(GameObjectType.GOLDMAN).get(0));
//        return actionResult;
    }

    private void swapObjects(AbstractGameObject object1, AbstractGameObject object2) {
//        swapCoordinates(object1, object2);
        Coordinate coordinate1 = object1.getCoordinate();
        Coordinate coordinate2 = object2.getCoordinate();
        object1.setCoordinate(coordinate2);
        object2.setCoordinate(coordinate1);
        gameObjects.put(coordinate2, object1);
        gameObjects.put(coordinate1, object2);
    }

    public Coordinate getNewCoordinate(MovingDirection direction, AbstractMovingObject movingObject) {

        int x = movingObject.getCoordinate().getX();
        int y = movingObject.getCoordinate().getY();

        Coordinate coordinate = new Coordinate(x, y);

        switch (direction) {
            case UP:
                coordinate.setY(y - movingObject.getStep());
                break;
            case DOWN:
                coordinate.setY(y + movingObject.getStep());
                break;
            case LEFT:
                coordinate.setX(x - movingObject.getStep());
                break;
            case RIGHT:
                coordinate.setX(x + movingObject.getStep());
                break;
        }
        return coordinate;
    }


    /*    private void swapCoordinates(AbstractGameObject object1, AbstractGameObject object2) {

            Coordinate coordinate1 = object1.getCoordinate();
            Coordinate coordinate2 = object2.getCoordinate();
            object1.setCoordinate(coordinate2);
            object2.setCoordinate(coordinate1);
        }*/
    private MovingDirection getRandomMoveDirection(AbstractMovingObject movingObject) {
        Goldman goldman = (Goldman) getGameObjects(GameObjectType.GOLDMAN).get(0);

        MovingDirection direction = null;
        Coordinate coordinate = goldman.getCoordinate();
        Coordinate monsterCoordinate = movingObject.getCoordinate();
        int number = getRandomInt(2);
        if (number == 1) {
            number = getRandomInt(2);
            switch (number) {
                case 1:
                    if (monsterCoordinate.getX() > coordinate.getX()) {
                        direction = MovingDirection.LEFT;
                    } else {
                        direction = MovingDirection.RIGHT;
                    }
                    break;
                case 2:
                    if (monsterCoordinate.getY() > coordinate.getY()) {
                        direction = MovingDirection.UP;
                    } else {
                        direction = MovingDirection.DOWN;
                    }
                    break;
            }
        } else {
            number = getRandomInt(2);
            switch (number) {
                case 1:
                    if (monsterCoordinate.getX() > coordinate.getX()) {
                        direction = MovingDirection.RIGHT;
                    } else {
                        direction = MovingDirection.LEFT;
                    }
                    break;
                case 2:
                    if (monsterCoordinate.getY() > coordinate.getY()) {
                        direction = MovingDirection.DOWN;
                    } else {
                        direction = MovingDirection.UP;
                    }
                    break;
            }
        }
        return direction;
    }

    private int getRandomInt(int i) {
        return new Random().nextInt(i) + 1;
    }

    @Override
    public void notifyMoveListeners(ActionResult result, Goldman goldman) {
        for (MoveResultListener listener : getMoveListeners()) {
            listener.notifyActionResult(result, goldman);
        }
    }

    @Override
    public void moveObjectRandom(GameObjectType objectType) {
        moveObject(null, objectType);
    }
}
