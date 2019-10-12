package com.kirilo.game.abstracts;

import com.kirilo.game.interfaces.collections.GameCollection;
import com.kirilo.game.interfaces.listeners.MoveResultListener;

import java.util.ArrayList;
import java.util.List;

public abstract class MapListenersRecorder implements GameCollection {
    private List<MoveResultListener> listeners = new ArrayList<>();

    @Override
    public List<MoveResultListener> getMoveListeners() {
        return listeners;
    }

    @Override
    public void addMoveListener(MoveResultListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeMoveListener(MoveResultListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void removeAllMoveListeners() {
        listeners.clear();
    }
}
