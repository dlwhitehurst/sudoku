package com.dlw.sudoku.utility;

import com.dlw.sudoku.types.Grid;

public class ConsoleUtility {

    private static ConsoleUtility instance = null;

    private ConsoleUtility() {
    }

    public static ConsoleUtility getInstance() {
        if (instance == null)
            instance = new ConsoleUtility();

        return instance;
    }

    public void printPuzzle(Grid grid) {
        grid.printGrid();
    }

    public void printRowComplete(int rowNo) {
        System.out.println("Row no. " + rowNo + " is complete!");
    }

    public void printColumnComplete(int colNo) {
        System.out.println("Column no. " + colNo + " is complete!");
    }
}
