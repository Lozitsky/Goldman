package com.kirilo.game.interfaces.listeners;

import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.objects.Goldman;

import java.util.List;

public interface MoveResultNotifier {
    List<MoveResultListener> getMoveListeners();

    void addMoveListener(MoveResultListener listener);

    void removeMoveListener(MoveResultListener listener);

    void removeAllMoveListeners();

    void notifyMoveListeners(ActionResult result, Goldman goldman);
}
