package com.dlw.sudoku.utility;

import com.dlw.sudoku.types.Grid;
import com.dlw.sudoku.types.LinearNine;

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

    public void printRowFixedAndComplete(int rowNo) { System.out.println("Row no. " + rowNo + " was fixed and is complete!"); }

    public void printColumnComplete(int colNo) {
        System.out.println("Column no. " + colNo + " is complete!");
    }

    public void printColumnFixedAndComplete(int colNo) { System.out.println("Column no. " + colNo + " was fixed and is complete!"); }

    public void printBlockComplete(int blockNo) {
        System.out.println("Block no. " + blockNo + " is complete!");
    }

    public void printFoundEightColumn(int colNo) {
        System.out.println("Column no. " + colNo + " is eight-count!");
    }

    public void printFoundEightRow(int rowNo) {
        System.out.println("Row no. " + rowNo + " is eight-count!");
    }

    public void printFoundEightBlock(int blockNo) {
        System.out.println("Block no. " + blockNo + " is eight-block!");
    }

    public void printFoundSevenColumn(int colNo) {
        System.out.println("Column no. " + colNo + " is seven-count!");
    }

    public void printFoundSevenRow(int rowNo) {
        System.out.println("Row no. " + rowNo + " is seven-count!");
    }

    public void printIntArray(int[] numbers) {
        for (int j=0; j < numbers.length; j++) {
            if (numbers[j] != 0) {
                System.out.print(numbers[j]);
            }
            if (numbers[j] != 0) {
                System.out.print(",");
            }
        }
        System.out.print("\n");
    }

    public void printLinearNine(String datatype, LinearNine obj) {
        if (datatype.equals(Constants.COLUMN)) {
            System.out.print(Constants.COLUMN + " ");
        }
        if (datatype.equals(Constants.ROW)) {
            System.out.print(Constants.ROW + " ");
        }
        for (int i=0; i<obj.size(); i++) {
            System.out.print(obj.getTheLinearNine()[i]);
            if (i != obj.size()-1) {
                System.out.print(",");
            }
        }
        System.out.print("\n");
    }

    public void printEndDebug() {
        System.out.println("######## END DEBUG ########");
    }
}
