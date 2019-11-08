package com.dlw.sudoku.utility;

import com.dlw.sudoku.Sudoku;
import com.dlw.sudoku.types.Grid;
import com.dlw.sudoku.types.GridNine;
import com.dlw.sudoku.types.LinearNine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SudokuUtility {

    private static SudokuUtility instance = null;

    private SudokuUtility() {
        // non-public constructor
    }

    public static SudokuUtility getInstance() {
        if (instance == null)
            instance = new SudokuUtility();
        return instance;
    }

    public void completeEightRow(int rowNum, Sudoku puzzle) {

        LinearNine row = puzzle.getRow(rowNum);

        // determine missing number
        int missing = row.getOneMissingNumber();

        // complete row
        row.populateMissingNumber(missing);

        // update puzzle row
        puzzle.updateRow(rowNum, row);

        ConsoleUtility.getInstance().printRowComplete(rowNum);

    }

    public void completeEightColumn(int columnNum, Sudoku puzzle) {

        LinearNine column = puzzle.getColumn(columnNum);

        // determine missing number
        int missing = column.getOneMissingNumber();

        // complete column
        column.populateMissingNumber(missing);

        // update puzzle column
        puzzle.updateColumn(columnNum, column);

        ConsoleUtility.getInstance().printColumnComplete(columnNum);
    }

    public void tryFixSevenRow(int rowNum, Sudoku puzzle) {
        // check cross columns for existence of one of the two missing numbers
        LinearNine row = puzzle.getRow(rowNum);

        // determine missing numbers (2)
        int [] missing = row.getMissingNumbers();
        ConsoleUtility.getInstance().printIntArray(missing);

        // need row indices for missing numbers
        int [] columns = row.getColumnIndices();
        ConsoleUtility.getInstance().printIntArray(columns);

        // get the columns for inspection
        LinearNine col1 = puzzle.getColumn(columns[0]);
        LinearNine col2 = puzzle.getColumn(columns[1]);

        ConsoleUtility.getInstance().printLinearNine(Constants.COLUMN, col1);
        ConsoleUtility.getInstance().printLinearNine(Constants.COLUMN, col2);

        // choose first number and inspect each column
        String first = String.valueOf(missing[0]);
        String second = String.valueOf(missing[1]);

        // if first number found within first column, place first number in other column and in row where it crosses
        for (int i=0; i<col1.size(); i++) {
            String tmp = String.valueOf(col1.getTheLinearNine()[i]);
            if (tmp.equals(first)) {
                loadRowOtherColumn(row, columns[1], tmp);
                puzzle.updateRow(rowNum, row);
                ConsoleUtility.getInstance().printRowFixedAndComplete(rowNum);
            }
        }

        // if first number found within second column, place first number in other column and in row where it crosses
        for (int i=0; i<col2.size(); i++) {
            String tmp = String.valueOf(col2.getTheLinearNine()[i]);
            if (tmp.equals(first)) {
                loadRowOtherColumn(row, columns[0], tmp);
                puzzle.updateRow(rowNum, row);
                ConsoleUtility.getInstance().printRowFixedAndComplete(rowNum);
            }
        }

        // if second number found within first column, place second number in other column and in row where it crosses
        for (int i=0; i<col1.size(); i++) {
            String tmp = String.valueOf(col1.getTheLinearNine()[i]);
            if (tmp.equals(second)) {
                loadRowOtherColumn(row, columns[1], tmp);
                puzzle.updateRow(rowNum, row);
                ConsoleUtility.getInstance().printRowFixedAndComplete(rowNum);
            }
        }

        // if second number found within second column, place second number in other column and in row where it crosses
        for (int i=0; i<col2.size(); i++) {
            String tmp = String.valueOf(col2.getTheLinearNine()[i]);
            if (tmp.equals(second)) {
                loadRowOtherColumn(row, columns[0], tmp);
                puzzle.updateRow(rowNum, row);
                ConsoleUtility.getInstance().printRowFixedAndComplete(rowNum);
            }
        }
    }

    public void tryFixSevenColumn(int colNum, Sudoku puzzle) {
        // check cross rows for existence of one of the two missing numbers
        LinearNine col = puzzle.getRow(colNum);

        // determine missing numbers (2)
        int [] missing = col.getMissingNumbers();
        ConsoleUtility.getInstance().printIntArray(missing);

        // need row indices for missing numbers
        int [] rows = col.getRowIndices();
        ConsoleUtility.getInstance().printIntArray(rows);

        // get the rows for inspection
        LinearNine row1 = puzzle.getRow(rows[0]);
        LinearNine row2 = puzzle.getRow(rows[1]);

        ConsoleUtility.getInstance().printLinearNine(Constants.ROW, row1);
        ConsoleUtility.getInstance().printLinearNine(Constants.ROW, row2);

        // choose first number and inspect each row
        String first = String.valueOf(missing[0]);
        String second = String.valueOf(missing[1]);

        // if first number found within first row, place first number in other row and in column where it crosses
        for (int i=0; i<row1.size(); i++) {
            String tmp = String.valueOf(row1.getTheLinearNine()[i]);
            if (tmp.equals(first)) {
                loadColumnOtherRow(col, rows[1], tmp);
                puzzle.updateColumn(colNum, col);
                ConsoleUtility.getInstance().printColumnFixedAndComplete(colNum);
            }
        }

        // if first number found within second row, place first number in other row and in column where it crosses
        for (int i=0; i<row2.size(); i++) {
            String tmp = String.valueOf(row2.getTheLinearNine()[i]);
            if (tmp.equals(first)) {
                loadColumnOtherRow(col, rows[0], tmp);
                puzzle.updateColumn(colNum, col);
                ConsoleUtility.getInstance().printColumnFixedAndComplete(colNum);
            }
        }

        // if second number found within first row, place second number in other row and in column where it crosses
        for (int i=0; i<row1.size(); i++) {
            String tmp = String.valueOf(row1.getTheLinearNine()[i]);
            if (tmp.equals(second)) {
                loadColumnOtherRow(col, rows[1], tmp);
                puzzle.updateColumn(colNum, col);
                ConsoleUtility.getInstance().printColumnFixedAndComplete(colNum);
            }
        }

        // if second number found within second row, place second number in other row and in column where it crosses
        for (int i=0; i<row2.size(); i++) {
            String tmp = String.valueOf(row2.getTheLinearNine()[i]);
            if (tmp.equals(second)) {
                loadColumnOtherRow(col, rows[0], tmp);
                puzzle.updateColumn(colNum, col);
                ConsoleUtility.getInstance().printColumnFixedAndComplete(colNum);
            }
        }
    }

    public void completeEightBlock(int blockNum, Sudoku puzzle) {
        GridNine block;
        // find the missing number and fill it
        switch (blockNum) {
            case 1:
                block = puzzle.getB1();
                addSingleMissingNumber(block);
                puzzle.setB1(block);
                ConsoleUtility.getInstance().printBlockComplete(1);
                break;
            case 2:
                block = puzzle.getB2();
                addSingleMissingNumber(block);
                puzzle.setB2(block);
                ConsoleUtility.getInstance().printBlockComplete(2);
                break;
            case 3:
                block = puzzle.getB3();
                addSingleMissingNumber(block);
                puzzle.setB3(block);
                ConsoleUtility.getInstance().printBlockComplete(3);
                break;
            case 4:
                block = puzzle.getB4();
                addSingleMissingNumber(block);
                puzzle.setB4(block);
                ConsoleUtility.getInstance().printBlockComplete(4);
                break;
            case 5:
                block = puzzle.getB5();
                addSingleMissingNumber(block);
                puzzle.setB5(block);
                ConsoleUtility.getInstance().printBlockComplete(5);
                break;
            case 6:
                block = puzzle.getB6();
                addSingleMissingNumber(block);
                puzzle.setB6(block);
                ConsoleUtility.getInstance().printBlockComplete(6);
                break;
            case 7:
                block = puzzle.getB7();
                addSingleMissingNumber(block);
                puzzle.setB7(block);
                ConsoleUtility.getInstance().printBlockComplete(7);
                break;
            case 8:
                block = puzzle.getB8();
                addSingleMissingNumber(block);
                puzzle.setB8(block);
                ConsoleUtility.getInstance().printBlockComplete(8);
                break;
            case 9:
                block = puzzle.getB9();
                addSingleMissingNumber(block);
                puzzle.setB9(block);
                ConsoleUtility.getInstance().printBlockComplete(9);
                break;
            default:
                break;
        }
    }

    public boolean isEightBlock(Grid block) {
        boolean retVal = false;
        int count = 0;
        for (int j = 0; j < 3; ++j) {
            if (block.getTheGrid()[0][j] == '*') {
                count++;
            }
            if (block.getTheGrid()[1][j] == '*') {
                count++;
            }
            if (block.getTheGrid()[2][j] == '*') {
                count++;
            }
        }
        if (count == 1) {
            retVal = true;
        }
        return retVal;
    }

    /**
     * Manually load each cell of the Sudoku grid
     */
    public void loadParent(Sudoku puzzle) {
// Row 1
        puzzle.getParent().populate(0,0,'4');
        puzzle.getParent().populate(0,1,'*');
        puzzle.getParent().populate(0,2,'9');
        puzzle.getParent().populate(0,3,'*');
        puzzle.getParent().populate(0,4,'5');
        puzzle.getParent().populate(0,5,'*');
        puzzle.getParent().populate(0,6,'7');
        puzzle.getParent().populate(0,7,'*');
        puzzle.getParent().populate(0,8,'1');
// Row 2
        puzzle.getParent().populate(1,0,'3');
        puzzle.getParent().populate(1,1,'7');
        puzzle.getParent().populate(1,2,'6');
        puzzle.getParent().populate(1,3,'8');
        puzzle.getParent().populate(1,4,'*');
        puzzle.getParent().populate(1,5,'*');
        puzzle.getParent().populate(1,6,'*');
        puzzle.getParent().populate(1,7,'*');
        puzzle.getParent().populate(1,8,'2');
// Row 3
        puzzle.getParent().populate(2,0,'1');
        puzzle.getParent().populate(2,1,'5');
        puzzle.getParent().populate(2,2,'8');
        puzzle.getParent().populate(2,3,'*');
        puzzle.getParent().populate(2,4,'*');
        puzzle.getParent().populate(2,5,'1');
        puzzle.getParent().populate(2,6,'*');
        puzzle.getParent().populate(2,7,'*');
        puzzle.getParent().populate(2,8,'3');
// Row 4
        puzzle.getParent().populate(3,0,'2');
        puzzle.getParent().populate(3,1,'6');
        puzzle.getParent().populate(3,2,'5');
        puzzle.getParent().populate(3,3,'3');
        puzzle.getParent().populate(3,4,'*');
        puzzle.getParent().populate(3,5,'9');
        puzzle.getParent().populate(3,6,'1');
        puzzle.getParent().populate(3,7,'*');
        puzzle.getParent().populate(3,8,'4');
// Row 5
        puzzle.getParent().populate(4,0,'9');
        puzzle.getParent().populate(4,1,'3');
        puzzle.getParent().populate(4,2,'8');
        puzzle.getParent().populate(4,3,'5');
        puzzle.getParent().populate(4,4,'1');
        puzzle.getParent().populate(4,5,'7');
        puzzle.getParent().populate(4,6,'2');
        puzzle.getParent().populate(4,7,'4');
        puzzle.getParent().populate(4,8,'6');
// Row 6
        puzzle.getParent().populate(5,0,'6');
        puzzle.getParent().populate(5,1,'*');
        puzzle.getParent().populate(5,2,'7');
        puzzle.getParent().populate(5,3,'6');
        puzzle.getParent().populate(5,4,'*');
        puzzle.getParent().populate(5,5,'2');
        puzzle.getParent().populate(5,6,'*');
        puzzle.getParent().populate(5,7,'*');
        puzzle.getParent().populate(5,8,'5');
// Row 7
        puzzle.getParent().populate(6,0,'*');
        puzzle.getParent().populate(6,1,'*');
        puzzle.getParent().populate(6,2,'*');
        puzzle.getParent().populate(6,3,'9');
        puzzle.getParent().populate(6,4,'1');
        puzzle.getParent().populate(6,5,'8');
        puzzle.getParent().populate(6,6,'*');
        puzzle.getParent().populate(6,7,'*');
        puzzle.getParent().populate(6,8,'8');
// Row 8
        puzzle.getParent().populate(7,0,'*');
        puzzle.getParent().populate(7,1,'*');
        puzzle.getParent().populate(7,2,'*');
        puzzle.getParent().populate(7,3,'*');
        puzzle.getParent().populate(7,4,'7');
        puzzle.getParent().populate(7,5,'5');
        puzzle.getParent().populate(7,6,'6');
        puzzle.getParent().populate(7,7,'*');
        puzzle.getParent().populate(7,8,'*');
// Row 9
        puzzle.getParent().populate(8,0,'7');
        puzzle.getParent().populate(8,1,'1');
        puzzle.getParent().populate(8,2,'4');
        puzzle.getParent().populate(8,3,'2');
        puzzle.getParent().populate(8,4,'6');
        puzzle.getParent().populate(8,5,'3');
        puzzle.getParent().populate(8,6,'8');
        puzzle.getParent().populate(8,7,'*');
        puzzle.getParent().populate(8,8,'9');

    }

    public void updateBlocks(Sudoku puzzle) {
        // Block 1
        puzzle.getB1().populate(0,0, puzzle.getParent().extract(0,0));
        puzzle.getB1().populate(0,1, puzzle.getParent().extract(0,1));
        puzzle.getB1().populate(0,2, puzzle.getParent().extract(0,2));
        puzzle.getB1().populate(1,0, puzzle.getParent().extract(1,0));
        puzzle.getB1().populate(1,1, puzzle.getParent().extract(1,1));
        puzzle.getB1().populate(1,2, puzzle.getParent().extract(1,2));
        puzzle.getB1().populate(2,0, puzzle.getParent().extract(2,0));
        puzzle.getB1().populate(2,1, puzzle.getParent().extract(2,1));
        puzzle.getB1().populate(2,2, puzzle.getParent().extract(2,2));

        // Block 2
        puzzle.getB2().populate(0,0, puzzle.getParent().extract(0,3));
        puzzle.getB2().populate(0,1, puzzle.getParent().extract(0,4));
        puzzle.getB2().populate(0,2, puzzle.getParent().extract(0,5));
        puzzle.getB2().populate(1,0, puzzle.getParent().extract(1,3));
        puzzle.getB2().populate(1,1, puzzle.getParent().extract(1,4));
        puzzle.getB2().populate(1,2, puzzle.getParent().extract(1,5));
        puzzle.getB2().populate(2,0, puzzle.getParent().extract(2,3));
        puzzle.getB2().populate(2,1, puzzle.getParent().extract(2,4));
        puzzle.getB2().populate(2,2, puzzle.getParent().extract(2,5));

        // Block 3
        puzzle.getB3().populate(0,0, puzzle.getParent().extract(0,6));
        puzzle.getB3().populate(0,1, puzzle.getParent().extract(0,7));
        puzzle.getB3().populate(0,2, puzzle.getParent().extract(0,8));
        puzzle.getB3().populate(1,0, puzzle.getParent().extract(1,6));
        puzzle.getB3().populate(1,1, puzzle.getParent().extract(1,7));
        puzzle.getB3().populate(1,2, puzzle.getParent().extract(1,8));
        puzzle.getB3().populate(2,0, puzzle.getParent().extract(2,6));
        puzzle.getB3().populate(2,1, puzzle.getParent().extract(2,7));
        puzzle.getB3().populate(2,2, puzzle.getParent().extract(2,8));

        // Block 4
        puzzle.getB4().populate(0,0, puzzle.getParent().extract(3,0));
        puzzle.getB4().populate(0,1, puzzle.getParent().extract(3,1));
        puzzle.getB4().populate(0,2, puzzle.getParent().extract(3,2));
        puzzle.getB4().populate(1,0, puzzle.getParent().extract(4,0));
        puzzle.getB4().populate(1,1, puzzle.getParent().extract(4,1));
        puzzle.getB4().populate(1,2, puzzle.getParent().extract(4,2));
        puzzle.getB4().populate(2,0, puzzle.getParent().extract(5,0));
        puzzle.getB4().populate(2,1, puzzle.getParent().extract(5,1));
        puzzle.getB4().populate(2,2, puzzle.getParent().extract(5,2));

        // Block 5
        puzzle.getB5().populate(0,0, puzzle.getParent().extract(3,3));
        puzzle.getB5().populate(0,1, puzzle.getParent().extract(3,4));
        puzzle.getB5().populate(0,2, puzzle.getParent().extract(3,5));
        puzzle.getB5().populate(1,0, puzzle.getParent().extract(4,3));
        puzzle.getB5().populate(1,1, puzzle.getParent().extract(4,4));
        puzzle.getB5().populate(1,2, puzzle.getParent().extract(4,5));
        puzzle.getB5().populate(2,0, puzzle.getParent().extract(5,3));
        puzzle.getB5().populate(2,1, puzzle.getParent().extract(5,4));
        puzzle.getB5().populate(2,2, puzzle.getParent().extract(5,5));

        // Block 6
        puzzle.getB6().populate(0,0, puzzle.getParent().extract(3,6));
        puzzle.getB6().populate(0,1, puzzle.getParent().extract(3,7));
        puzzle.getB6().populate(0,2, puzzle.getParent().extract(3,8));
        puzzle.getB6().populate(1,0, puzzle.getParent().extract(4,6));
        puzzle.getB6().populate(1,1, puzzle.getParent().extract(4,7));
        puzzle.getB6().populate(1,2, puzzle.getParent().extract(4,8));
        puzzle.getB6().populate(2,0, puzzle.getParent().extract(5,6));
        puzzle.getB6().populate(2,1, puzzle.getParent().extract(5,7));
        puzzle.getB6().populate(2,2, puzzle.getParent().extract(5,8));

        // Block 7
        puzzle.getB7().populate(0,0, puzzle.getParent().extract(6,0));
        puzzle.getB7().populate(0,1, puzzle.getParent().extract(6,1));
        puzzle.getB7().populate(0,2, puzzle.getParent().extract(6,2));
        puzzle.getB7().populate(1,0, puzzle.getParent().extract(7,0));
        puzzle.getB7().populate(1,1, puzzle.getParent().extract(7,1));
        puzzle.getB7().populate(1,2, puzzle.getParent().extract(7,2));
        puzzle.getB7().populate(2,0, puzzle.getParent().extract(8,0));
        puzzle.getB7().populate(2,1, puzzle.getParent().extract(8,1));
        puzzle.getB7().populate(2,2, puzzle.getParent().extract(8,2));

        // Block 8
        puzzle.getB8().populate(0,0, puzzle.getParent().extract(6,3));
        puzzle.getB8().populate(0,1, puzzle.getParent().extract(6,4));
        puzzle.getB8().populate(0,2, puzzle.getParent().extract(6,5));
        puzzle.getB8().populate(1,0, puzzle.getParent().extract(7,3));
        puzzle.getB8().populate(1,1, puzzle.getParent().extract(7,4));
        puzzle.getB8().populate(1,2, puzzle.getParent().extract(7,5));
        puzzle.getB8().populate(2,0, puzzle.getParent().extract(8,3));
        puzzle.getB8().populate(2,1, puzzle.getParent().extract(8,4));
        puzzle.getB8().populate(2,2, puzzle.getParent().extract(8,5));

        // Block 9
        puzzle.getB9().populate(0,0, puzzle.getParent().extract(6,6));
        puzzle.getB9().populate(0,1, puzzle.getParent().extract(6,7));
        puzzle.getB9().populate(0,2, puzzle.getParent().extract(6,8));
        puzzle.getB9().populate(1,0, puzzle.getParent().extract(7,6));
        puzzle.getB9().populate(1,1, puzzle.getParent().extract(7,7));
        puzzle.getB9().populate(1,2, puzzle.getParent().extract(7,8));
        puzzle.getB9().populate(2,0, puzzle.getParent().extract(8,6));
        puzzle.getB9().populate(2,1, puzzle.getParent().extract(8,7));
        puzzle.getB9().populate(2,2, puzzle.getParent().extract(8,8));
    }

    public void loadParentFromCSVFile(Sudoku puzzle) throws FileNotFoundException {
        // open and read file
        BufferedReader br = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("puzzle46.csv").getFile()));
        try {
            String line;
            int rowNum = 1;
            while ((line = br.readLine()) != null) {
                // process the line
                switch (rowNum) {
                    case 1:
                        loadRow(line, 0, puzzle);
                        rowNum++;
                        break;
                    case 2:
                        loadRow(line, 1, puzzle);
                        rowNum++;
                        break;
                    case 3:
                        loadRow(line, 2, puzzle);
                        rowNum++;
                        break;
                    case 4:
                        loadRow(line, 3, puzzle);
                        rowNum++;
                        break;
                    case 5:
                        loadRow(line, 4, puzzle);
                        rowNum++;
                        break;
                    case 6:
                        loadRow(line, 5, puzzle);
                        rowNum++;
                        break;
                    case 7:
                        loadRow(line, 6, puzzle);
                        rowNum++;
                        break;
                    case 8:
                        loadRow(line, 7, puzzle);
                        rowNum++;
                        break;
                    case 9:
                        loadRow(line, 8, puzzle);
                        rowNum++;
                        break;
                    default:
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadRow(String line, int rowIndex, Sudoku puzzle) {
        StringTokenizer toker = new StringTokenizer(line, ",");
        int colIndex = 0;
        while(toker.hasMoreTokens()) {
            String strNo = toker.nextToken();
            puzzle.getParent().populate(rowIndex, colIndex, strNo.charAt(0));
            colIndex++;
        }
    }

    private void addSingleMissingNumber(GridNine block) {
        block.settMissingNumberIndices();
        int number = block.getOneMissingNumber();
        int rowIndex = block.getEmptyRow();
        int colIndex = block.getEmptyCol();
        block.getTheGrid()[rowIndex][colIndex] = new Integer(number).toString(number).charAt(0);
    }

    private void loadRowOtherColumn(LinearNine row, int rowIndex, String value) {
        row.getTheLinearNine()[rowIndex-1] = value.charAt(0);
    }

    private void loadColumnOtherRow(LinearNine col, int colIndex, String value) {
        col.getTheLinearNine()[colIndex-1] = value.charAt(0);
    }

}
