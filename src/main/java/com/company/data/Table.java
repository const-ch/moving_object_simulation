package com.company.data;

import com.company.data.enums.Direction;

public abstract class Table {

   abstract public void checkIfObjectOnTable();

    protected int xPos;
    protected int yPos;

    protected Shape shape = Shape.RECTANGULAR;

    Direction objectDirection = Direction.NORTH;

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Direction getObjectDirection() {
        return objectDirection;
    }

    public void setObjectDirection(Direction objectDirection) {
        this.objectDirection = objectDirection;
    }

    protected enum Shape {
        RECTANGULAR,TRIANGLE
    }

}
