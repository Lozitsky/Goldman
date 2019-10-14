package com.kirilo.game.interfaces.listeners;

import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.ActionResult;


public interface MoveResultListener {
    void notifyActionResult(ActionResult actionResult, AbstractMovingObject movingObject);
}
