package org.example.controller;

import org.example.view.Menu;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShowMenuByClosing extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        (new Menu()).showMenu();
    }
}
