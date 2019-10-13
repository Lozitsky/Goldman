package com.kirilo.game.objects.movesrategies;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.collections.GameCollection;
import com.kirilo.game.interfaces.movesrategies.MoveStrategy;

import java.util.Random;

public class AgressiveMoving implements MoveStrategy {
    private MovingDirection[] directions = MovingDirection.values();
    private AbstractMovingObject movingObject;
    private GameCollection gameCollection;

    @Override
    public MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject gameObject, GameCollection gameCollection) {
        this.movingObject = movingObject;
        this.gameCollection = gameCollection;

        MovingDirection direction = searchAction(ActionResult.DIE, false);

        if (direction == null) {
            direction = searchAction(ActionResult.MOVE, true);
        }

        return direction;
    }

    private MovingDirection searchAction(ActionResult actionResult, boolean random) {
        MovingDirection direction = null;
        if (random) {
            do {
                direction = getRandomDirection();
            } while (!checkActionResult(actionResult, direction));
        } else {
            for (MovingDirection movingDirection : directions) {
                if (checkActionResult(actionResult, movingDirection)) {
                    direction = movingDirection;
                    break;
                }
            }
        }
        return direction;
    }

    private MovingDirection getRandomDirection() {
        return directions[new Random().nextInt(directions.length)];
    }

    private boolean checkActionResult(ActionResult actionResult, MovingDirection direction) {
        AbstractGameObject objectByCoordinate = gameCollection.getObjectByCoordinate(movingObject.getDirectionCoordinate(direction));
        return movingObject.doAction(objectByCoordinate).equals(actionResult);

    }
}
