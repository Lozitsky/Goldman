package com.kirilo.game.interfaces.movesrategies;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.collections.GameCollection;

public interface MoveStrategy {
    MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject gameObject, GameCollection gameCollection);
}
