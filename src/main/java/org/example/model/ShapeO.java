package org.example.model;

import java.util.List;

public class ShapeO extends ShapeSuper {

    ShapeO(int x, int y, List<Integer> x_coordinate, List<Integer> y_coordinate) {
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
        x_coordinate.add(x+DOT_SIZE);
        y_coordinate.add(y-DOT_SIZE);
    }

    @Override
    public void rotate() {}
}
