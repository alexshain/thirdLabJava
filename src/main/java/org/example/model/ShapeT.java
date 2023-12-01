package org.example.model;

import java.util.List;

public class ShapeT extends ShapeSuper {

    ShapeT(int x, int y, List<Integer> x_coordinate, List<Integer> y_coordinate) {
        super(x, y, x_coordinate, y_coordinate);
    }
    @Override
    public void setCoordinates() {
        x_coordinate.add((int)domainCoord.get(0,1));
        y_coordinate.add((int)domainCoord.get(1,1));
        x_coordinate.add((int)domainCoord.get(0,3));
        y_coordinate.add((int)domainCoord.get(1,3));
        x_coordinate.add((int)domainCoord.get(0,4));
        y_coordinate.add((int)domainCoord.get(1,4));
        x_coordinate.add((int)domainCoord.get(0,7));
        y_coordinate.add((int)domainCoord.get(1,7));
    }

    @Override
    public void rotate() {
        domainCoord = domainCoord.mult(rotateMatrix);
        if(x_coordinate.get(2) < 9*DOT_SIZE && x_coordinate.get(2) > 0) {
            x_coordinate.set(0, (int) domainCoord.get(0, 1) + x_coordinate.get(2) - (int) domainCoord.get(0, 4) - 4 * DOT_SIZE);
            y_coordinate.set(0, (int) domainCoord.get(1, 1) + y_coordinate.get(2) + 3 * DOT_SIZE);
            x_coordinate.set(1, (int) domainCoord.get(0, 3) + x_coordinate.get(2) - (int) domainCoord.get(0, 4) - 4 * DOT_SIZE);
            y_coordinate.set(1, (int) domainCoord.get(1, 3) + y_coordinate.get(2) + 3 * DOT_SIZE);
            x_coordinate.set(3, (int) domainCoord.get(0, 7) + x_coordinate.get(2) - (int) domainCoord.get(0, 4) - 4 * DOT_SIZE);
            y_coordinate.set(3, (int) domainCoord.get(1, 7) + y_coordinate.get(2) + 3 * DOT_SIZE);
        }
    }
}
