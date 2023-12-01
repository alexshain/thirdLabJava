package org.example.controller;

import org.example.view.GameField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGamePressHandler implements ActionListener {
    JFrame window;

    public NewGamePressHandler(JFrame window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.setVisible(false);
        (new GameField()).showGameField();
    }
}
