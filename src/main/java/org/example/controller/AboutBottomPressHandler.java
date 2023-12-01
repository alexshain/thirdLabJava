package org.example.controller;

import org.example.view.AboutShow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutBottomPressHandler implements ActionListener {
    JFrame window;

    public AboutBottomPressHandler(JFrame window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.setVisible(false);
        (new AboutShow()).showAboutWindow();
    }
}
