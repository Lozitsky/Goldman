package com.kirilo.game.objects.maps;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.MovingObject;
import com.kirilo.game.interfaces.collections.GameCollection;
import com.kirilo.game.objects.Coordinate;
import com.kirilo.game.objects.Nothing;

import java.util.*;

public class MapCollection implements GameCollection {
    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);

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
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public Collection<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values());
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
    public ActionResult moveObject(MovingDirection direction, GameObjectType objectType) {
        ActionResult actionResult = null;
        for (AbstractGameObject gameObject : this.getGameObjects(objectType)) {
            if (gameObject instanceof AbstractMovingObject) {
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;
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
                }
            }
        }
        return actionResult;
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

/*    private void swapCoordinates(AbstractGameObject object1, AbstractGameObject object2) {

        Coordinate coordinate1 = object1.getCoordinate();
        Coordinate coordinate2 = object2.getCoordinate();
        object1.setCoordinate(coordinate2);
        object2.setCoordinate(coordinate1);
    }*/

    public Coordinate getNewCoordinate(MovingDirection direction, MovingObject movingObject) {

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
}
