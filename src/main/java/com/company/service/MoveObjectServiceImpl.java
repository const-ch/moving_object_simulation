package  com.company.service;

import  com.company.data.Table;
import  com.company.data.RectangularTable;
import  com.company.data.enums.Move;
import  com.company.service.exception.ObjectFallFromTableException;

import static  com.company.data.enums.Direction.EAST;
import static  com.company.data.enums.Direction.NORTH;
import static  com.company.data.enums.Direction.SOUTH;
import static  com.company.data.enums.Direction.WEST;

public class MoveObjectServiceImpl implements MoveObjectService {

    public static final int OBJECT_FALL_POSITION = -1;

    Table table;

    public void initTable(int heigth, int width, int Xpos, int Ypos) {
        table = new RectangularTable(heigth, width, Xpos, Ypos);
    }

    public boolean handleCommand(int moveCode) {

        Move move = Move.valueByCode(moveCode);

        if (Move.QUIT == move) {
            return true;
        }

        try {
            moveTheObject(move);
            return false;
        } catch (ObjectFallFromTableException e) {
            setPositionToFall();
            return true;
        }
    }

    @Override
    public String retrievePosition() {
        return table.getxPos() + " " + table.getyPos();
    }

    private void moveTheObject(Move move) {
        switch (move) {
            case FORWARD:
                stepForward();
                break;
            case BACKWARD:
                stepBackward();
                break;
            case ROTATE_LEFT:
                turnLeft();
                break;
            case ROTATE_RIGHT:
                turnRight();
                break;
        }
    }

    private void stepForward() {
        stepOneStepByDirection(true);
    }

    private void stepBackward() {
        stepOneStepByDirection(false);
    }

    private void stepOneStepByDirection(boolean forward) {
        int directionMultiplier = forward ? 1 : -1;
        switch (table.getObjectDirection()) {
            case NORTH:
                table.setyPos(table.getyPos() - 1 * directionMultiplier);
                break;
            case EAST:
                table.setxPos(table.getxPos() + 1 * directionMultiplier);
                break;
            case SOUTH:
                table.setyPos(table.getyPos() + 1 * directionMultiplier);
                break;
            case WEST:
                table.setxPos(table.getxPos() - 1 * directionMultiplier);
                break;
        }
        table.checkIfObjectOnTable();
    }

    private void turnRight() {
        switch (table.getObjectDirection()) {
            case NORTH:
                table.setObjectDirection(EAST);
                break;
            case EAST:
                table.setObjectDirection(SOUTH);
                break;
            case SOUTH:
                table.setObjectDirection(WEST);
                break;
            case WEST:
                table.setObjectDirection(NORTH);
                break;
        }
    }

    private void turnLeft() {
        switch (table.getObjectDirection()) {
            case NORTH:
                table.setObjectDirection(WEST);
                break;
            case WEST:
                table.setObjectDirection(SOUTH);
                break;
            case SOUTH:
                table.setObjectDirection(EAST);
                break;
            case EAST:
                table.setObjectDirection(NORTH);
                break;
        }
    }

    private void setPositionToFall() {
        table.setxPos(OBJECT_FALL_POSITION);
        table.setyPos(OBJECT_FALL_POSITION);
    }

}
