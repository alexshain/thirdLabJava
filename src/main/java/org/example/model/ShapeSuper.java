package org.example.model;

import org.ejml.simple.SimpleMatrix;

import java.util.List;

public abstract class ShapeSuper implements Shape {
    final int x;
    final int y;
    public List<Integer> x_coordinate;
    public List<Integer> y_coordinate;
    int DOT_SIZE = 25;

    SimpleMatrix domainCoord = SimpleMatrix.ones(2,9); //Создаю матрицу координат квадратного домена
    SimpleMatrix rotateMatrix = SimpleMatrix.ones(9,9);

    ShapeSuper(int x, int y, List<Integer> x_coordinate, List<Integer> y_coordinate) {
        this.x = x;
        this.y = y;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        domainCoord.setRow(0,0,x-DOT_SIZE,x-DOT_SIZE,x-DOT_SIZE,x,x,x,x+DOT_SIZE,x+DOT_SIZE,x+DOT_SIZE);
        domainCoord.setRow(1,0,y,y-DOT_SIZE,y-2*DOT_SIZE,y,y-DOT_SIZE,y-2*DOT_SIZE,y,y-DOT_SIZE,y-2*DOT_SIZE);
        rotateMatrix.fill(0);
        rotateMatrix.set(0, 6, 1);
        rotateMatrix.set(1, 3, 1);
        rotateMatrix.set(2, 0, 1);
        rotateMatrix.set(3, 7, 1);
        rotateMatrix.set(5, 1, 1);
        rotateMatrix.set(6, 8, 1);
        rotateMatrix.set(7, 5, 1);
        rotateMatrix.set(8, 2, 1);
    }
}
