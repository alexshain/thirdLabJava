package org.example.controller;

import org.example.model.ScoresFilePerformer;
import org.example.view.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitBottonPressHandler implements ActionListener {
    JFrame window;
    GameLogicManager gameLogicManager;

    public ExitBottonPressHandler(JFrame window, GameLogicManager gameLogicManager) {
        this.window = window;
        this.gameLogicManager = gameLogicManager;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        window.setVisible(false);
        (new ScoresFilePerformer()).writeScores(gameLogicManager.getCounter().getPoints());
        (new Menu()).showMenu();
    }
}
