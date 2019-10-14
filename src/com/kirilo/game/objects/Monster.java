package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.SoundObject;

public class Monster extends AbstractMovingObject implements SoundObject {

    public Monster(Coordinate coordinate) {
        setType(GameObjectType.MONSTER);
        setCoordinate(coordinate);
        setIcon(getImageIcon("com/kirilo/game/images/monster_up.jpg"));
    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case UP:
                setIcon(getImageIcon("com/kirilo/game/images/monster_up.jpg"));
                break;
            case DOWN:
                setIcon(getImageIcon("com/kirilo/game/images/monster_down.jpg"));
                break;
            case LEFT:
                setIcon(getImageIcon("com/kirilo/game/images/monster_left.jpg"));
                break;
            case RIGHT:
                setIcon(getImageIcon("com/kirilo/game/images/monster_right.jpg"));
                break;
        }
    }

    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {
        switch (gameObject.getType()) {
            case TREASURE:
            case MONSTER:
                return ActionResult.NO_ACTION;
            case GOLDMAN:
                return ActionResult.DIE;
            default:
                return super.doAction(gameObject);
        }

    }

    @Override
    public String getSoundName(ActionResult actionResult) {
        switch (actionResult) {
            case DIE:
                return WavPlayer.DIE_WAV;
        }
        return null;
    }
}
