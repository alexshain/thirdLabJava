package org.example.controller;

import org.example.model.Counter;
import org.example.model.GameLogic;
import org.example.model.ScoresFilePerformer;

import javax.swing.*;
import java.util.Collections;

public class GameLogicManager {
    public boolean inGame = true;
    public boolean write = true;
    public Counter counter = new Counter();

    public void manage(GameLogic game, DelayManager delay, Timer timer) {
        if(inGame) {
            game.move(delay, counter);
            setDelay(delay, game, timer);
        }
        if(!inGame && write) {
            (new ScoresFilePerformer()).writeScores(counter.getPoints());
            write = false;
        }
    }

    public Counter getCounter() {
        return counter;
    }

    public Boolean getState(GameLogic game) {
        if(!game.getY_structure().isEmpty() && Collections.min(game.getY_structure()) < 0) {
            inGame = false;
        } else inGame = true;
        return inGame;
    }

    public void setDelay(DelayManager delay, GameLogic game, Timer timer) {
        if(game.getDirection().get("down")) {
            timer.setDelay(delay.getDelay()/4);
            timer.start();
        } else {
            timer.setDelay(delay.getDelay());
            timer.start();
        }
        game.initDirection();
    }
}
