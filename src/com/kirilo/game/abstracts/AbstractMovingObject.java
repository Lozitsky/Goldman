package com.kirilo.game.abstracts;

import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.MovingObject;
import com.kirilo.game.objects.Coordinate;

public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {
    public abstract void changeIcon(MovingDirection direction);

    private int step = 1;

    @Override
    public ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject) {
        actionBeforeMove(direction);
        return doAction(gameObject);
    }

    @Override
    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    protected void actionBeforeMove(MovingDirection direction) {
        changeIcon(direction);
    }

    public ActionResult doAction(AbstractGameObject gameObject) {
        if (gameObject == null) {
            return ActionResult.NO_ACTION;
        }
        switch (gameObject.getType()) {
            case NOTHING:
                return ActionResult.MOVE;
            default:
                return ActionResult.NO_ACTION;
        }
    }
/*    @Override
    public void move(MovingDirection direction, AbstractGameMap abstractGameMap) {
        Coordinate newCoordinate = getNewCoordinate(direction);
        AbstractGameObject objectByCoordinate = abstractGameMap.getGameCollection().getObjectByCoordinate(newCoordinate);

        switch (objectByCoordinate.getType()) {
            case NOTHING:
                changeIcon(direction);
                setCoordinate(newCoordinate);
            default: {
            }
        }
    }*/

    public Coordinate getNewCoordinate(MovingDirection direction) {

        int x = getCoordinate().getX();
        int y = getCoordinate().getY();

        Coordinate coordinate = new Coordinate(x, y);

        switch (direction) {
            case UP:
                coordinate.setY(--y);
                break;
            case DOWN:
                coordinate.setY(++y);
                break;
            case LEFT:
                coordinate.setX(--x);
                break;
            case RIGHT:
                coordinate.setX(++x);
                break;
        }
        return coordinate;
    }

/*    private ImageIcon iconLeft;
    private ImageIcon iconRight;
    private ImageIcon iconUp;
    private ImageIcon iconDown;*/

/*    @Override
    public void move(MovingDirection direction, AbstractGameMap abstractGameMap) {
        int x = getCoordinate().getX();
        int y = getCoordinate().getY();

        Coordinate coordinate = new Coordinate(x, y);

        switch (direction) {
            case UP:
                setIcon(getIconUp());
                coordinate.setCoordinate(x, --y);
                break;
            case DOWN:
                setIcon(getIconDown());
                coordinate.setCoordinate(x, ++y);
                break;
            case LEFT:
                setIcon(getIconLeft());
                coordinate.setCoordinate(--x, y);
                break;
            case RIGHT:
                setIcon(getIconRight());
                coordinate.setCoordinate(++x, y);
                break;
        }

        setCoordinate(coordinate);
    }*/

/*    @Override
    public ImageIcon getIconLeft() {
        return iconLeft;
    }

    @Override
    public void setIconLeft(ImageIcon iconLeft) {
        this.iconLeft = iconLeft;
    }

    @Override
    public ImageIcon getIconRight() {
        return iconRight;
    }

    @Override
    public void setIconRight(ImageIcon iconRight) {
        this.iconRight = iconRight;
    }

    @Override
    public ImageIcon getIconUp() {
        return iconUp;
    }

    @Override
    public void setIconUp(ImageIcon iconUp) {
        this.iconUp = iconUp;
    }

    @Override
    public ImageIcon getIconDown() {
        return iconDown;
    }

    @Override
    public void setIconDown(ImageIcon iconDown) {
        this.iconDown = iconDown;
    }*/
}
