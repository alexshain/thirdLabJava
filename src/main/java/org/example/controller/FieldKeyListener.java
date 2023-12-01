package org.example.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

public class FieldKeyListener extends KeyAdapter {

    public Map<String, Boolean> direction;
    public FieldKeyListener(Map<String, Boolean> direction) {
        this.direction = direction;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key1 = e.getKeyCode();
        if(key1 == KeyEvent.VK_LEFT) {
            direction.put("left", true);
        }
        if(key1 == KeyEvent.VK_RIGHT) {
            direction.put("right", true);
        }
        if(key1 == KeyEvent.VK_DOWN) {
            direction.put("down", true);
        }
        if(key1 == KeyEvent.VK_SPACE) {
            direction.put("rotate", true);
        }
    }
}
