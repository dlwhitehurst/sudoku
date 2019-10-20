package com.dlw.sudoku;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello Sudoku!");
        Sudoku sudoku = new Sudoku();
        SudokuUtility.getInstance().completeEightRow(9, sudoku);
        SudokuUtility.getInstance().completeEightColumn(9, sudoku);

        ConsoleUtility.getInstance().printPuzzle(sudoku.getParent());
    }
}
