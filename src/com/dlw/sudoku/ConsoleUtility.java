package com.dlw.sudoku;

public class ConsoleUtility {

    private static ConsoleUtility instance = null;

    private ConsoleUtility() {
    }

    static ConsoleUtility getInstance() {
        if (instance == null)
            instance = new ConsoleUtility();

        return instance;
    }

    void printPuzzle(Grid grid) {
        grid.printGrid();
    }

    void printRowComplete(int rowNo) {
        System.out.println("Row no. " + rowNo + " is complete!");
    }

    void printColumnComplete(int colNo) {
        System.out.println("Column no. " + colNo + " is complete!");
    }
}