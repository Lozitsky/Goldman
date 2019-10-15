package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.sound.SoundObject;

public class Goldman extends AbstractMovingObject implements SoundObject {

    private int score;
    private int turnsNumber;
    private int totalScore;

    public Goldman(Coordinate coordinate) {
        setType(GameObjectType.GOLDMAN);
        setCoordinate(coordinate);
        setIcon(getImageIcon("com/kirilo/game/images/goldman_up.png"));
    }

    public void addSTotalScore(int score) {
        this.totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
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

    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {

        turnsNumber++;

        switch (gameObject.getType()) {
            case TREASURE:
                totalScore += ((Treasure) gameObject).getScore();
                return ActionResult.COLLECT_TREASURE;
            case MONSTER:
                return ActionResult.DIE;
            case EXIT:
                totalScore *= 2;
                return ActionResult.WIN;
            default:
                return super.doAction(gameObject);
        }
    }

    @Override
    public String getSoundName(ActionResult actionResult) {
        switch (actionResult) {
            case DIE:
                return WavPlayer.DIE_WAV;
            case COLLECT_TREASURE:
                return "treasure.wav";
            case WIN:
                return "win.wav";
        }
        return null;
    }

/*    @Override
    public void getMoveResult(AbstractGameObject gameObjectWithNewCoordinate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/
}
