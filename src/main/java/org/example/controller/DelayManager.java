package org.example.controller;

public class DelayManager {
    public Integer delay = 500;

    public void changeDelay() {
        if(delay > 100) { //типо тостигнута максимальная скорость
            delay -= 50;
        }
    }

    public Integer getDelay() {
        return delay;
    }
}
