package org.example.view;

import org.example.controller.ShowMenuByClosing;

import javax.swing.*;

public class AboutShow {
    JFrame window = new JFrame();

    public AboutShow() {
        window.setTitle("About");
        window.addWindowListener(new ShowMenuByClosing());
    }

    public void showAboutWindow() {
        window.add(new AboutTextPrinter());
        window.setSize(400,100);
        window.setLocation(1000,50);
        window.setVisible(true);
    }
}
