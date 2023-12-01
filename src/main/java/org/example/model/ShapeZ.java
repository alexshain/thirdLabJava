package org.example.model;

import java.util.List;

public class ShapeZ extends ShapeSuper {
    int i = 0;

    ShapeZ(int x, int y, List<Integer> x_coordinate, List<Integer> y_coordinate) {
        super(x, y, x_coordinate, y_coordinate);
    }
    @Override
    public void setCoordinates() {
        x_coordinate.add(x);
        y_coordinate.add(y);
        x_coordinate.add(x+DOT_SIZE);
        y_coordinate.add(y);
        x_coordinate.add(x);
        y_coordinate.add(y-DOT_SIZE);
        x_coordinate.add(x-DOT_SIZE);
        y_coordinate.add(y-DOT_SIZE);
    }

    @Override
    public void rotate() {
        if(x_coordinate.get(2) < 9*DOT_SIZE && x_coordinate.get(2) > 0) {
            x_coordinate.set(0, x_coordinate.get(0) - (int) Math.pow(-1, i) * DOT_SIZE);
            y_coordinate.set(0, y_coordinate.get(0) - (int) Math.pow(-1, i) * DOT_SIZE);
            x_coordinate.set(1, x_coordinate.get(1) - (int) Math.pow(-1, i) * 2 * DOT_SIZE);
            x_coordinate.set(3, x_coordinate.get(3) + (int) Math.pow(-1, i) * DOT_SIZE);
            y_coordinate.set(3, y_coordinate.get(3) - (int) Math.pow(-1, i) * DOT_SIZE);
            i++;
        }
    }
}
