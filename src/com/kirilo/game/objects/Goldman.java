package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;

public class Goldman extends AbstractMovingObject {

    private int score;
    private int turnsNumber;

    public Goldman(Coordinate coordinate) {
        setType(GameObjectType.GOLDMAN);
        setCoordinate(coordinate);
        setIconUp(getImageIcon("com/kirilo/game/images/goldman_up.png"));
        setIconDown(getImageIcon("com/kirilo/game/images/goldman_down.png"));
        setIconLeft(getImageIcon("com/kirilo/game/images/goldman_left.png"));
        setIconRight(getImageIcon("com/kirilo/game/images/goldman_right.png"));

        setIcon(getIconUp());
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTurnsNumber() {
        return turnsNumber;
    }

    public void setTurnsNumber(int turnsNumber) {
        this.turnsNumber = turnsNumber;
    }

    @Override
    public void getMoveResult(AbstractGameObject gameObjectWithNewCoordinate) {

    }

    @Override
    public void move(MovingDirection direction) {

    }
}
