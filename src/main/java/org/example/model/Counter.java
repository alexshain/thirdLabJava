package org.example.model;

public class Counter {
    public Integer points = 0;

    public void countPoints() {
        points += 1;
    }

    public Integer getPoints() {
        return points;
    }
}
