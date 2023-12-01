package org.example.view;

import org.example.controller.AboutBottomPressHandler;
import org.example.controller.NewGamePressHandler;
import org.example.controller.ScoresPressHandler;

import javax.swing.*;
import java.awt.*;

public class Menu {
    JFrame window = new JFrame();

    public Menu() {
        window.setTitle("Tetris");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        showMenu();
    }

    public void showMenu() {
        JLayeredPane lp = window.getLayeredPane();
        JButton newGameButton = new JButton("New Game");
        newGameButton.setBackground(Color.YELLOW);
        newGameButton.setBounds(135,80,110,50);
        JButton aboutButton = new JButton("About");
        aboutButton.setBackground(Color.YELLOW);
        aboutButton.setBounds(135,150,110,50);
        JButton highScoresButton = new JButton("High Scores");
        highScoresButton.setBackground(Color.YELLOW);
        highScoresButton.setBounds(135,220,110,50);
        lp.add(newGameButton, JLayeredPane.POPUP_LAYER);
        lp.add(aboutButton, JLayeredPane.POPUP_LAYER);
        lp.add(highScoresButton, JLayeredPane.POPUP_LAYER);
        newGameButton.addActionListener(new NewGamePressHandler(window));
        aboutButton.addActionListener(new AboutBottomPressHandler(window));
        highScoresButton.addActionListener(new ScoresPressHandler(window));
        window.setSize(400,520);
        window.setLocation(400,50);
        window.setVisible(true);
    }
}
