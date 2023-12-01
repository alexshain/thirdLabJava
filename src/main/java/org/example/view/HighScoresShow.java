package org.example.view;

import org.example.controller.ShowMenuByClosing;

import javax.swing.*;

public class HighScoresShow {
    JFrame window = new JFrame();

    public HighScoresShow() {
        window.setTitle("HighScores");
        window.addWindowListener(new ShowMenuByClosing());
    }

    public void showHighScores() {
        window.add(new HighScoresPrinter());
        window.setSize(400,100);
        window.setLocation(1000,50);
        window.setVisible(true);
    }
}
