package org.example.view;

import org.example.model.ScoresFilePerformer;

import javax.swing.*;
import java.awt.*;

public class HighScoresPrinter extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String aboutTetris1 = "Best Result: " + (new ScoresFilePerformer()).getBestResult();
        Font f = new Font("Times New Roman", Font.PLAIN, 15);
        g.setColor(Color.BLACK);
        g.setFont(f);
        g.drawString(aboutTetris1, 5, 15);
    }
}
