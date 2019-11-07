package com.dlw.sudoku;

import com.dlw.sudoku.utility.ConsoleUtility;
import com.dlw.sudoku.utility.SudokuUtility;

public class Application {

    public static void main(String[] args) {

        System.out.println("Hello Sudoku!");

        Sudoku sudoku = new Sudoku();
        SudokuUtility.getInstance().loadParent(sudoku);
        SudokuUtility.getInstance().updateBlocks(sudoku);

        // print puzzle
        ConsoleUtility.getInstance().printPuzzle(sudoku.getParent());

        // solve puzzle
        sudoku.solve();

        // print solution
        ConsoleUtility.getInstance().printPuzzle(sudoku.getParent());
    }
}
