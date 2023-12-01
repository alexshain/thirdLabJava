package org.example.model;

import java.util.Collections;
import java.util.List;
import org.example.controller.DelayManager;

public class StructureBuilder {
    List<Integer> x_figure;
    List<Integer> y_figure;
    List<Integer> x_structure;
    List<Integer> y_structure;
    int DOT_SIZE = 25;

    StructureBuilder(List<Integer> x_figure, List<Integer> y_figure, List<Integer> x_structure, List<Integer> y_structure){
        this.x_figure = x_figure;
        this.y_figure = y_figure;
        this.x_structure = x_structure;
        this.y_structure = y_structure;
    }

    public void setStructure() {
        for(int i=0;i<x_figure.size();i++) {
            x_structure.add(x_figure.get(i));
            y_structure.add(y_figure.get(i));
        }
        x_figure.clear();
        y_figure.clear();
    }

    public void checkCollision() {
        if(Collections.max(y_figure) > 17*DOT_SIZE) {
            setStructure();
        } else {
            for(int i=0;i<y_structure.size();i++) {
                for(int j=0;j<x_figure.size();j++) {
                    if(y_figure.get(j).equals(y_structure.get(i)-DOT_SIZE)
                            && x_figure.get(j).equals(x_structure.get(i))){
                        setStructure();
                    }
                }
            }
        }
    }

    public void shift(int height) {
        for(int i=0;i<y_structure.size();i++) {
            if(y_structure.get(i).equals(height)) {
                y_structure.remove(i);
                x_structure.remove(i);
                i--;
            }
        }
        for(int i=0;i<y_structure.size();i++) {
            if(y_structure.get(i) < height) {
                y_structure.set(i, y_structure.get(i) + DOT_SIZE);
            }
        }
    }

    public void checkRowFilling(Counter counter, DelayManager delay) {
        for(int i=18;i>0;i--) {
            int countRow = 0;
            for (Integer item : y_structure) {
                if (item.equals(i * DOT_SIZE)) {
                    countRow++;
                }
            }
            if(countRow == 10) {
                shift(i * DOT_SIZE);
                counter.countPoints();
                delay.changeDelay();
            }
        }
    }
}
