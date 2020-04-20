package com.company.data;

import com.company.service.exception.ObjectFallFromTableException;

public class RectangularTable extends Table {

    private final int heigth;
    private final int width;

    public RectangularTable(int heigth, int width, int xpos, int ypos) {
        this.heigth = heigth;
        this.width = width;
        xPos = xpos;
        yPos = ypos;

        shape = Shape.RECTANGULAR;
    }

    public void checkIfObjectOnTable(){
        if(shape == Shape.RECTANGULAR){
            if(xPos<0 || yPos <0 || xPos >=width || yPos >=heigth){
                    throw new ObjectFallFromTableException();
            }
        } else {
            throw new UnsupportedOperationException(" Rectangular table supported for now, only.");
        }
    }
}

