package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;

public class Goldman extends AbstractMovingObject {

    private int score;
    private int turnsNumber;

    public Goldman(Coordinate coordinate) {
        setType(GameObjectType.GOLDMAN);
        setCoordinate(coordinate);
/*        setIconUp(getImageIcon("com/kirilo/game/images/goldman_up.png"));
        setIconDown(getImageIcon("com/kirilo/game/images/goldman_down.png"));
        setIconLeft(getImageIcon("com/kirilo/game/images/goldman_left.png"));
        setIconRight(getImageIcon("com/kirilo/game/images/goldman_right.png"));*/

//        setIcon(getIconUp());
        setIcon(getImageIcon("com/kirilo/game/images/goldman_up.png"));
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
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case UP:
                setIcon(getImageIcon("com/kirilo/game/images/goldman_up.png"));
                break;
            case DOWN:
                setIcon(getImageIcon("com/kirilo/game/images/goldman_down.png"));
                break;
            case RIGHT:
                setIcon(getImageIcon("com/kirilo/game/images/goldman_right.png"));
                break;
            case LEFT:
                setIcon(getImageIcon("com/kirilo/game/images/goldman_left.png"));
                break;
        }
    }

/*    @Override
    public void getMoveResult(AbstractGameObject gameObjectWithNewCoordinate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/
}
