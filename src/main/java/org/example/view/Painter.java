package org.example.view;

import org.example.controller.DelayManager;
import org.example.controller.GameLogicManager;
import org.example.model.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painter extends JPanel implements ActionListener {
    private final GameLogic gameLogic = new GameLogic();
    private Image dot;
    public DelayManager delay = new DelayManager();
    public Timer timer = new Timer(delay.getDelay(), this);
    public GameLogicManager gameLogicManager;

    public Painter(GameLogicManager gameLogicManager) {
        setBackground(Color.BLACK);
        loadImage();
        timer.start();
        addKeyListener(gameLogic.getKeyListener());
        setFocusable(true);
        this.gameLogicManager = gameLogicManager;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int DOT_SIZE = 25;
        int dots = 4;
        g.setColor(Color.WHITE);
        g.fillRect(2, 2, 247,473);
        g.fillRect(255, 50, 120, 60);
        g.setColor(Color.BLACK);
        g.fillRect(258, 53, 114, 54);
        if(gameLogicManager.getState(gameLogic)) {
            for(int i=0;i<dots;i++) {
                g.drawImage(dot, gameLogic.getX_figure().get(i), gameLogic.getY_figure().get(i), this);
            }
            for(int i=0;i<gameLogic.getX_structure().size();i++) {
                g.drawImage(dot, gameLogic.getX_structure().get(i), gameLogic.getY_structure().get(i), this);
            }
            Font f = new Font("Times New Roman", Font.BOLD, 15);
            g.setColor(Color.YELLOW);
            g.setFont(f);
            g.drawString(gameLogicManager.getCounter().getPoints().toString(), 310, 80);
        } else {
            String str = "GAME OVER";
            Font f = new Font("Times New Roman", Font.BOLD, 25);
            g.setColor(Color.BLACK);
            g.setFont(f);
            g.drawString(str, 2*DOT_SIZE, 10*DOT_SIZE);
        }
    }

    public void loadImage() {
        ImageIcon iip = new ImageIcon("/Users/sasha/IdeaProjects/" +
                "ThirdLabJava/src/main/java/org/example/model/pic.png");
        dot = iip.getImage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameLogicManager.manage(gameLogic, delay, timer);
        repaint();
    }
}
