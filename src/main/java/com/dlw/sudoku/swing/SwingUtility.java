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

import com.dlw.sudoku.Sudoku;
import com.dlw.sudoku.types.LinearNine;

import javax.swing.*;
import java.awt.*;

public class SwingUtility {

    private static SwingUtility instance = null;

    private SwingUtility() {
        // non-public constructor
    }

    public static SwingUtility getInstance() {
        if (instance == null)
            instance = new SwingUtility();
        return instance;
    }

    public void renderPuzzle(Sudoku puzzle, String title) {
        JFrame jFrame = new JFrame(title);

        // Create layout and add buttons to show restraints
        DPanel dPanel = new DPanel(new GridLayout(9, 9));

        // row 1
        LinearNine row1 = puzzle.getRow(1);
        for (int i=0; i<row1.size(); i++) {
            JButton button = new JButton();
            if (String.valueOf(row1.getTheLinearNine()[i]).equals("*")) {
                button.setText("");
            } else {
                button.setText(String.valueOf(row1.getTheLinearNine()[i]));
            }
            button.setFont(new Font("Arial", Font.PLAIN, 48));
            dPanel.add(button);
        }

        // row 2
        LinearNine row2 = puzzle.getRow(2);
        for (int i=0; i<row2.size(); i++) {
            JButton button = new JButton();
            if (String.valueOf(row2.getTheLinearNine()[i]).equals("*")) {
                button.setText("");
            } else {
                button.setText(String.valueOf(row2.getTheLinearNine()[i]));
            }
            button.setFont(new Font("Arial", Font.PLAIN, 48));
            dPanel.add(button);
        }

        // row 3
        LinearNine row3 = puzzle.getRow(3);
        for (int i=0; i<row3.size(); i++) {
            JButton button = new JButton();
            if (String.valueOf(row3.getTheLinearNine()[i]).equals("*")) {
                button.setText("");
            } else {
                button.setText(String.valueOf(row3.getTheLinearNine()[i]));
            }
            button.setFont(new Font("Arial", Font.PLAIN, 48));
            dPanel.add(button);
        }

        // row 4
        LinearNine row4 = puzzle.getRow(4);
        for (int i=0; i<row4.size(); i++) {
            JButton button = new JButton();
            if (String.valueOf(row4.getTheLinearNine()[i]).equals("*")) {
                button.setText("");
            } else {
                button.setText(String.valueOf(row4.getTheLinearNine()[i]));
            }
            button.setFont(new Font("Arial", Font.PLAIN, 48));
            dPanel.add(button);
        }

        // row 5
        LinearNine row5 = puzzle.getRow(5);
        for (int i=0; i<row5.size(); i++) {
            JButton button = new JButton();
            if (String.valueOf(row5.getTheLinearNine()[i]).equals("*")) {
                button.setText("");
            } else {
                button.setText(String.valueOf(row5.getTheLinearNine()[i]));
            }
            button.setFont(new Font("Arial", Font.PLAIN, 48));
            dPanel.add(button);
        }

        // row6
        LinearNine row6 = puzzle.getRow(6);
        for (int i=0; i<row6.size(); i++) {
            JButton button = new JButton();
            if (String.valueOf(row6.getTheLinearNine()[i]).equals("*")) {
                button.setText("");
            } else {
                button.setText(String.valueOf(row6.getTheLinearNine()[i]));
            }
            button.setFont(new Font("Arial", Font.PLAIN, 48));
            dPanel.add(button);
        }

        // row 7
        LinearNine row7 = puzzle.getRow(7);
        for (int i=0; i<row7.size(); i++) {
            JButton button = new JButton();
            if (String.valueOf(row7.getTheLinearNine()[i]).equals("*")) {
                button.setText("");
            } else {
                button.setText(String.valueOf(row7.getTheLinearNine()[i]));
            }
            button.setFont(new Font("Arial", Font.PLAIN, 48));
            dPanel.add(button);
        }

        // row 8
        LinearNine row8 = puzzle.getRow(8);
        for (int i=0; i<row8.size(); i++) {
            JButton button = new JButton();
            if (String.valueOf(row8.getTheLinearNine()[i]).equals("*")) {
                button.setText("");
            } else {
                button.setText(String.valueOf(row8.getTheLinearNine()[i]));
            }
            button.setFont(new Font("Arial", Font.PLAIN, 48));
            dPanel.add(button);
        }

        // row 9
        LinearNine row9 = puzzle.getRow(9);
        for (int i=0; i<row9.size(); i++) {
            JButton button = new JButton();
            if (String.valueOf(row9.getTheLinearNine()[i]).equals("*")) {
                button.setText("");
            } else {
                button.setText(String.valueOf(row9.getTheLinearNine()[i]));
            }
            button.setFont(new Font("Arial", Font.PLAIN, 48));
            dPanel.add(button);
        }

        jFrame.setContentPane(dPanel);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(new Dimension(600,600));
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
