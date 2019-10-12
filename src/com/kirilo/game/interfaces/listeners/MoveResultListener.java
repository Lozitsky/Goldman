package com.kirilo.game.interfaces.listeners;

import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.objects.Goldman;

public interface MoveResultListener {
    void notifyActionResult(ActionResult actionResult, Goldman goldman);
}
