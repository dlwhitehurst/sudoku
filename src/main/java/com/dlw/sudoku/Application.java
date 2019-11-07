package com.dlw.sudoku;

import com.dlw.sudoku.utility.ConsoleUtility;
import com.dlw.sudoku.utility.SudokuUtility;

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

        // solve puzzle
        sudoku.solve();

        // print solution
        ConsoleUtility.getInstance().printPuzzle(sudoku.getParent());
    }
}
