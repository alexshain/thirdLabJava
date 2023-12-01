package org.example.controller;

import org.example.view.HighScoresShow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoresPressHandler implements ActionListener {
    JFrame window;

    public ScoresPressHandler(JFrame window) {
        this.window = window;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        window.setVisible(false);
        (new HighScoresShow()).showHighScores();
    }
}
