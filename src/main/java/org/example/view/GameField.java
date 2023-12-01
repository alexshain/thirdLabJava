package org.example.view;

import org.example.controller.ExitBottonPressHandler;
import org.example.controller.GameLogicManager;

import javax.swing.*;
import java.awt.*;

public class GameField {
    JFrame window = new JFrame();

    public GameField() {
        window.setTitle("Tetris");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showGameField() {
        GameLogicManager gameLogicManager = new GameLogicManager();
        Painter painter = new Painter(gameLogicManager);
        JLayeredPane lp = window.getLayeredPane();
        ShowPoints points = new ShowPoints();
        lp.add(points.writeName(), JLayeredPane.POPUP_LAYER);
        window.add(painter);
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.YELLOW);
        exitButton.setBounds(280,350,70,30);
        lp.add(exitButton, JLayeredPane.POPUP_LAYER);
        exitButton.addActionListener(new ExitBottonPressHandler(window, gameLogicManager));
        window.setSize(400,520);
        window.setLocation(400,50);
        window.setVisible(true);
    }
}
