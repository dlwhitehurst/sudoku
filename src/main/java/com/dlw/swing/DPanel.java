package com.dlw.swing;

import javax.swing.*;
import java.awt.*;

public class DPanel extends JPanel {

    public DPanel(GridLayout layout) {
        super(layout);
    }

    @Override public void paintComponent(Graphics g)
    {
        // this first
        super.paintComponent(g);

        //Get the current size of this component
        Dimension d = this.getSize();

        //draw in black
        g.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        //draw horizontal lines
        g2.drawLine(0,192,d.width,192);
        g2.drawLine(0,384,d.width,384);

        // draw vertical lines
        g2.drawLine(201,d.height,201,0);
        g2.drawLine(398,d.height, 398,0);

    }
}
