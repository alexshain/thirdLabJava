package org.example.model;

import org.example.controller.FieldKeyListener;
import org.example.controller.DelayManager;

import java.util.*;
import java.util.List;

public class GameLogic {
    private final int DOT_SIZE = 25;
    private final List<Integer> x_figure = new ArrayList<>();
    private final List<Integer> y_figure = new ArrayList<>();
    private final List<Integer> x_structure = new ArrayList<>();
    private final List<Integer> y_structure = new ArrayList<>();
    private final String[] shapes = new String[]{"I", "J", "L", "O", "S", "T", "Z"};
    private Shape shape;
    public Map<String, Boolean> direction = new HashMap<>();
    public FieldKeyListener keyListener = new FieldKeyListener(direction);

    public void initDirection() {
        direction.put("left", false);
        direction.put("right", false);
        direction.put("down", false);
        direction.put("rotate", false);
    }

    public void initShape() {
        int x = 4 * DOT_SIZE;
        int y = -2 * DOT_SIZE;
        Factory factory = new Factory(x, y, x_figure, y_figure);
        try {
            shape = factory.create(shapes[(new Random()).nextInt(7)]);
            shape.setCoordinates();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public GameLogic() {
        initShape();
        initDirection();
    }

    public void checkValidFigureDynamic() {
        for(int i=0;i<y_structure.size();i++) {
            for(int j=0;j<x_figure.size();j++) {
                if(y_figure.get(j).equals(y_structure.get(i))
                        && x_figure.get(j).equals(x_structure.get(i)+DOT_SIZE)) {
                    direction.put("left", false);
                }
                if(y_figure.get(j).equals(y_structure.get(i))
                        && x_figure.get(j).equals(x_structure.get(i)-DOT_SIZE)) {
                    direction.put("right", false);
                }
            }
            if(y_figure.get(2) >= y_structure.get(i)-DOT_SIZE
                    && x_figure.get(2).equals(x_structure.get(i)+DOT_SIZE)) {
                direction.put("rotate", false);
            }
            if(y_figure.get(2) >= y_structure.get(i)-DOT_SIZE
                    && x_figure.get(2).equals(x_structure.get(i)-DOT_SIZE)) {
                direction.put("rotate", false);
            }
        }
    }

    public void move(DelayManager delaySetter, Counter counter) {
        int dots = 4;
        for(int i=dots;i>0;i--) {
            y_figure.set(i-1, y_figure.get(i-1) + DOT_SIZE);
        }
        checkValidFigureDynamic();
        if(direction.get("left") && Collections.min(x_figure) > 0) {
            for(int i=dots;i>0;i--) {
                x_figure.set(i-1, x_figure.get(i-1) - DOT_SIZE);
            }
        }
        if(direction.get("right") && Collections.max(x_figure) < 9*DOT_SIZE) {
            for(int i=dots;i>0;i--) {
                x_figure.set(i-1, x_figure.get(i-1) + DOT_SIZE);
            }
        }
        if(direction.get("rotate")) {
            shape.rotate();
        }
        StructureBuilder structure = new StructureBuilder(x_figure, y_figure,x_structure, y_structure);
        structure.checkCollision();
        if(!x_structure.isEmpty()) {
            structure.checkRowFilling(counter, delaySetter);
        }
        if(x_figure.isEmpty()) {
            initShape();
        }
    }
    public Map<String,Boolean> getDirection() {
        return direction;
    }
    public FieldKeyListener getKeyListener() {return keyListener;}
    public List<Integer> getX_figure() {
        return x_figure;
    }
    public List<Integer> getY_figure() {
        return y_figure;
    }
    public List<Integer> getX_structure() {
        return x_structure;
    }
    public List<Integer> getY_structure() {
        return y_structure;
    }
}