package org.example.view;

import javax.swing.*;
import java.awt.*;

public class AboutTextPrinter extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String aboutTetris1 =  "Это тетрис - игра, где ты можешь";
        String aboutTetris2 = "складывать фигуры и зарабатывать очки";
        Font f = new Font("Times New Roman", Font.BOLD, 15);
        g.setColor(Color.BLACK);
        g.setFont(f);
        g.drawString(aboutTetris1, 5, 15);
        g.drawString(aboutTetris2, 5, 35);
    }
}
