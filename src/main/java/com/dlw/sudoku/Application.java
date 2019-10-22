package com.dlw.sudoku;

import com.dlw.sudoku.utility.ConsoleUtility;
import com.dlw.sudoku.utility.SudokuUtility;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello Sudoku!");

        Sudoku sudoku = new Sudoku();
        SudokuUtility.getInstance().loadParent(sudoku);
        SudokuUtility.getInstance().updateBlocks(sudoku);
        if (SudokuUtility.getInstance().isEightBlock(sudoku.getB1())) {
            System.out.println("Block 1 (b1) is an EightBlock, cool beans!");
        } else {
            System.out.println("Nope, not an EightBlock");
        }
        sudoku.solve();
        //SudokuUtility.getInstance().completeEightRow(9, sudoku);
        //SudokuUtility.getInstance().completeEightColumn(9, sudoku);

        ConsoleUtility.getInstance().printPuzzle(sudoku.getParent());
    }
}
