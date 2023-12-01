package org.example.view;

import javax.swing.*;
import java.awt.*;

public class ShowPoints extends JComponent {
    private final Color color = Color.WHITE;

    public JLabel writeName() {
        JLabel label = new JLabel("Points");
        label.setForeground(color);
        label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        label.setBounds(295,10,150,50);
        return label;
    }

}
