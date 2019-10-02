package com.kirilo.game.enums;

import java.io.Serializable;

public enum GameObjectType implements Serializable {
    MONSTER(5),
    TREASURE(4),
    EXIT(3),
    WALL(2),
    GOLDMAN(1),
    NOTHING(-1);


    private int priority;

    private GameObjectType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
