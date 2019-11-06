package com.dlw.sudoku;

import com.dlw.sudoku.utility.ConsoleUtility;
import com.dlw.sudoku.utility.SudokuUtility;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello Sudoku!");

        Sudoku sudoku = new Sudoku();
        SudokuUtility.getInstance().loadParent(sudoku);
        SudokuUtility.getInstance().updateBlocks(sudoku);

        // print base puzzle
        ConsoleUtility.getInstance().printPuzzle(sudoku.getParent());


        sudoku.solve();

        ConsoleUtility.getInstance().printPuzzle(sudoku.getParent());
    }
}
