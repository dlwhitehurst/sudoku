/*
 * Copyright (c) 2019. David L. Whitehurst
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dlw.sudoku.swing;

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
