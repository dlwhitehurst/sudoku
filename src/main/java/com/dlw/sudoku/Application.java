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

package com.dlw.sudoku;

import com.dlw.sudoku.utility.ConsoleUtility;
import com.dlw.sudoku.utility.SudokuUtility;
import com.dlw.sudoku.swing.SwingUtility;

import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] args) {

        System.out.println("Hello Sudoku!");

        Sudoku sudoku = new Sudoku();
        // load puzzle from CSV file
        try {
            SudokuUtility.getInstance().loadParentFromCSVFile(sudoku);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // update internal blocks (data structures)
        SudokuUtility.getInstance().updateBlocks(sudoku);

        // print puzzle
        ConsoleUtility.getInstance().printPuzzle(sudoku.getParent());
        //SwingUtility.getInstance().renderPuzzle(sudoku, "Original Puzzle");

        // solve puzzle
        sudoku.solve();

        // print solution
        //ConsoleUtility.getInstance().printPuzzle(sudoku.getParent());
        SwingUtility.getInstance().renderPuzzle(sudoku, "Solved Sudoku");
    }
}
