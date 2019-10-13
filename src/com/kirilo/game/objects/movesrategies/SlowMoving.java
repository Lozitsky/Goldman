package com.kirilo.game.objects.movesrategies;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.collections.GameCollection;
import com.kirilo.game.interfaces.movesrategies.MoveStrategy;
import com.kirilo.game.objects.Coordinate;

import java.util.Random;

public class SlowMoving implements MoveStrategy {
    @Override
    public MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject gameObject, GameCollection gameCollection) {
//        Goldman goldman = (Goldman) getGameObjects(GameObjectType.GOLDMAN).get(0);

        MovingDirection direction = null;
        Coordinate coordinate = gameObject.getCoordinate();
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
}
