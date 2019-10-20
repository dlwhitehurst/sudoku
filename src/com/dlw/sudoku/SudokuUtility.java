package com.dlw.sudoku;

public class SudokuUtility {

    private static SudokuUtility instance = null;

    private SudokuUtility() {
        // non-public constructor
    }

    static SudokuUtility getInstance() {
        if (instance == null)
            instance = new SudokuUtility();
        return instance;
    }

    public void completeEightRow(int rowNum, Sudoku puzzle) {

        SudokuRow row = puzzle.getRow(rowNum);
        for(int j = 0; j < row.size(); ++j) {
            System.out.print(row.getTheLinearNine()[j]);
        }
        System.out.println("");
        // determine missing number
        int missing = row.getNinthNumber();
        System.out.println("The missing number is: " + missing);

        // complete row
        row.populateMissingNumber(missing);
        for(int j = 0; j < row.size(); ++j) {
            System.out.print(row.getTheLinearNine()[j]);
        }
        System.out.println("");

        // update puzzle row
        puzzle.updateRow(rowNum, row);

    }

    public void completeEightColumn(int columnNum, Sudoku puzzle) {

        SudokuColumn column = puzzle.getColumn(columnNum);
        for(int j = 0; j < column.size(); ++j) {
            System.out.print(column.getTheLinearNine()[j]);
        }
        System.out.println("");
        // determine missing number
        int missing = column.getNinthNumber();
        System.out.println("The missing number is: " + missing);

        // complete column
        column.populateMissingNumber(missing);
        for(int j = 0; j < column.size(); ++j) {
            System.out.print(column.getTheLinearNine()[j]);
        }
        System.out.println("");

        // update puzzle column
        puzzle.updateColumn(columnNum, column);

    }

    boolean isEightColumn(SudokuColumn puzzleColumn) {

        return true;
    }

    boolean isEightBlock(GridNine puzzleBlock) {

        return true;
    }
}
