package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.GameObjectType;

public class Treasure extends AbstractGameObject {
    private int score = 5;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Treasure(Coordinate coordinate) {
        setType(GameObjectType.TREASURE);
        setCoordinate(coordinate);
        setIcon(getImageIcon("com/kirilo/game/images/gold.png"));
    }
}
