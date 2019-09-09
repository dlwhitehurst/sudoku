package com.dlw.sudoku;

import java.io.Console;

class Sudoku {
    private static Grid sudokuGrid;

    private static Grid one3x3;
    private static Grid two3x3;
    private static Grid three3x3;
    private static Grid four3x3;
    private static Grid five3x3;
    private static Grid six3x3;
    private static Grid seven3x3;
    private static Grid eight3x3;
    private static Grid nine3x3;

    private static Boolean b_one3x3 = false;
    private static Boolean b_two3x3 = false;
    private static Boolean b_three3x3 = false;
    private static Boolean b_four3x3 = false;
    private static Boolean b_five3x3 = false;
    private static Boolean b_six3x3 = false;
    private static Boolean b_seven3x3 = false;
    private static Boolean b_eight3x3 = false;
    private static Boolean b_nine3x3 = false;

    private Boolean row1 = false; // not complete
    private Boolean row2 = false; // not complete
    private Boolean row3 = false; // not complete
    private Boolean row4 = false; // not complete
    private Boolean row5 = false; // not complete
    private Boolean row6 = false; // not complete
    private Boolean row7 = false; // not complete
    private Boolean row8 = false; // not complete
    private Boolean row9 = false; // not complete

    private Boolean col1 = false; // not complete
    private Boolean col2 = false; // not complete
    private Boolean col3 = false; // not complete
    private Boolean col4 = false; // not complete
    private Boolean col5 = false; // not complete
    private Boolean col6 = false; // not complete
    private Boolean col7 = false; // not complete
    private Boolean col8 = false; // not complete
    private Boolean col9 = false; // not complete

    Sudoku() {
        sudokuGrid = new Grid(9,9); // 9x9 Sudoku Grid (Pre-loaded)
        one3x3 = new Grid(3,3);
        two3x3 = new Grid(3,3);
        three3x3 = new Grid(3,3);
        four3x3 = new Grid(3,3);
        five3x3 = new Grid(3,3);
        six3x3 = new Grid(3,3);
        seven3x3 = new Grid(3,3);
        eight3x3 = new Grid(3,3);
        nine3x3 = new Grid(3,3);

        preLoad(); // load the puzzle
        updateThreeByThrees(); // load the 3x3s from puzzle (current-state)
        solve();
        ConsoleUtility.getInstance().printPuzzle(sudokuGrid);
    }

    private void solve() {
        do {
            // check rows
            for (int a = 0; a < 9; a++) {
                int rowNo = a + 1;
                if (checkRow(a)) {
                    ConsoleUtility.getInstance().printRowComplete(rowNo);
                }
            }

            // check cols
            for (int b = 0; b < 9; b++) {
                int colNo = b + 1;
                if (checkColumn(b)) {
                    ConsoleUtility.getInstance().printColumnComplete(colNo);
                }
            }

        } while (!checkPuzzle());
    }

    private Boolean checkPuzzle() {
        return true;
    }

    private void updateThreeByThrees() {
        // 1
        one3x3.populate(0,0, sudokuGrid.extract(0,0));
        one3x3.populate(0,1, sudokuGrid.extract(0,1));
        one3x3.populate(0,2, sudokuGrid.extract(0,2));
        one3x3.populate(1,0, sudokuGrid.extract(1,0));
        one3x3.populate(1,1, sudokuGrid.extract(1,1));
        one3x3.populate(1,2, sudokuGrid.extract(1,2));
        one3x3.populate(2,0, sudokuGrid.extract(2,0));
        one3x3.populate(2,1, sudokuGrid.extract(2,1));
        one3x3.populate(2,2, sudokuGrid.extract(2,2));

        // 2
        two3x3.populate(0,0, sudokuGrid.extract(0,3));
        two3x3.populate(0,1, sudokuGrid.extract(0,4));
        two3x3.populate(0,2, sudokuGrid.extract(0,5));
        two3x3.populate(1,0, sudokuGrid.extract(1,3));
        two3x3.populate(1,1, sudokuGrid.extract(1,4));
        two3x3.populate(1,2, sudokuGrid.extract(1,5));
        two3x3.populate(2,0, sudokuGrid.extract(2,3));
        two3x3.populate(2,1, sudokuGrid.extract(2,4));
        two3x3.populate(2,2, sudokuGrid.extract(2,5));

        //3
        three3x3.populate(0,0, sudokuGrid.extract(0,6));
        three3x3.populate(0,1, sudokuGrid.extract(0,7));
        three3x3.populate(0,2, sudokuGrid.extract(0,8));
        three3x3.populate(1,0, sudokuGrid.extract(1,6));
        three3x3.populate(1,1, sudokuGrid.extract(1,7));
        three3x3.populate(1,2, sudokuGrid.extract(1,8));
        three3x3.populate(2,0, sudokuGrid.extract(2,6));
        three3x3.populate(2,1, sudokuGrid.extract(2,7));
        three3x3.populate(2,2, sudokuGrid.extract(2,8));

        // 4
        four3x3.populate(0,0, sudokuGrid.extract(3,0));
        four3x3.populate(0,1, sudokuGrid.extract(3,1));
        four3x3.populate(0,2, sudokuGrid.extract(3,2));
        four3x3.populate(1,0, sudokuGrid.extract(4,0));
        four3x3.populate(1,1, sudokuGrid.extract(4,1));
        four3x3.populate(1,2, sudokuGrid.extract(4,2));
        four3x3.populate(2,0, sudokuGrid.extract(5,0));
        four3x3.populate(2,1, sudokuGrid.extract(5,1));
        four3x3.populate(2,2, sudokuGrid.extract(5,2));

        // 5
        five3x3.populate(0,0, sudokuGrid.extract(3,3));
        five3x3.populate(0,1, sudokuGrid.extract(3,4));
        five3x3.populate(0,2, sudokuGrid.extract(3,5));
        five3x3.populate(1,0, sudokuGrid.extract(4,3));
        five3x3.populate(1,1, sudokuGrid.extract(4,4));
        five3x3.populate(1,2, sudokuGrid.extract(4,5));
        five3x3.populate(2,0, sudokuGrid.extract(5,3));
        five3x3.populate(2,1, sudokuGrid.extract(5,4));
        five3x3.populate(2,2, sudokuGrid.extract(5,5));

        // 6
        six3x3.populate(0,0, sudokuGrid.extract(3,6));
        six3x3.populate(0,1, sudokuGrid.extract(3,7));
        six3x3.populate(0,2, sudokuGrid.extract(3,8));
        six3x3.populate(1,0, sudokuGrid.extract(4,6));
        six3x3.populate(1,1, sudokuGrid.extract(4,7));
        six3x3.populate(1,2, sudokuGrid.extract(4,8));
        six3x3.populate(2,0, sudokuGrid.extract(5,6));
        six3x3.populate(2,1, sudokuGrid.extract(5,7));
        six3x3.populate(2,2, sudokuGrid.extract(5,8));

        // 7
        seven3x3.populate(0,0, sudokuGrid.extract(6,0));
        seven3x3.populate(0,1, sudokuGrid.extract(6,1));
        seven3x3.populate(0,2, sudokuGrid.extract(6,2));
        seven3x3.populate(1,0, sudokuGrid.extract(7,0));
        seven3x3.populate(1,1, sudokuGrid.extract(7,1));
        seven3x3.populate(1,2, sudokuGrid.extract(7,2));
        seven3x3.populate(2,0, sudokuGrid.extract(8,0));
        seven3x3.populate(2,1, sudokuGrid.extract(8,1));
        seven3x3.populate(2,2, sudokuGrid.extract(8,2));

        // 8
        eight3x3.populate(0,0, sudokuGrid.extract(6,3));
        eight3x3.populate(0,1, sudokuGrid.extract(6,4));
        eight3x3.populate(0,2, sudokuGrid.extract(6,5));
        eight3x3.populate(1,0, sudokuGrid.extract(7,3));
        eight3x3.populate(1,1, sudokuGrid.extract(7,4));
        eight3x3.populate(1,2, sudokuGrid.extract(7,5));
        eight3x3.populate(2,0, sudokuGrid.extract(8,3));
        eight3x3.populate(2,1, sudokuGrid.extract(8,4));
        eight3x3.populate(2,2, sudokuGrid.extract(8,5));

        // 9
        nine3x3.populate(0,0, sudokuGrid.extract(6,6));
        nine3x3.populate(0,1, sudokuGrid.extract(6,7));
        nine3x3.populate(0,2, sudokuGrid.extract(6,8));
        nine3x3.populate(1,0, sudokuGrid.extract(7,6));
        nine3x3.populate(1,1, sudokuGrid.extract(7,7));
        nine3x3.populate(1,2, sudokuGrid.extract(7,8));
        nine3x3.populate(2,0, sudokuGrid.extract(8,6));
        nine3x3.populate(2,1, sudokuGrid.extract(8,7));
        nine3x3.populate(2,2, sudokuGrid.extract(8,8));
    }
    /**
     * Manually load each cell of the Sudoku grid
     */
    private void preLoad() {
// 1
        sudokuGrid.populate(0,0,'4');
        sudokuGrid.populate(0,1,'*');
        sudokuGrid.populate(0,2,'9');
        sudokuGrid.populate(0,3,'*');
        sudokuGrid.populate(0,4,'5');
        sudokuGrid.populate(0,5,'*');
        sudokuGrid.populate(0,6,'7');
        sudokuGrid.populate(0,7,'*');
        sudokuGrid.populate(0,8,'1');
// 2
        sudokuGrid.populate(1,0,'*');
        sudokuGrid.populate(1,1,'*');
        sudokuGrid.populate(1,2,'2');
        sudokuGrid.populate(1,3,'8');
        sudokuGrid.populate(1,4,'*');
        sudokuGrid.populate(1,5,'*');
        sudokuGrid.populate(1,6,'*');
        sudokuGrid.populate(1,7,'*');
        sudokuGrid.populate(1,8,'*');
// 3
        sudokuGrid.populate(2,0,'*');
        sudokuGrid.populate(2,1,'*');
        sudokuGrid.populate(2,2,'*');
        sudokuGrid.populate(2,3,'*');
        sudokuGrid.populate(2,4,'*');
        sudokuGrid.populate(2,5,'1');
        sudokuGrid.populate(2,6,'*');
        sudokuGrid.populate(2,7,'*');
        sudokuGrid.populate(2,8,'*');
// 4
        sudokuGrid.populate(3,0,'*');
        sudokuGrid.populate(3,1,'*');
        sudokuGrid.populate(3,2,'*');
        sudokuGrid.populate(3,3,'3');
        sudokuGrid.populate(3,4,'*');
        sudokuGrid.populate(3,5,'9');
        sudokuGrid.populate(3,6,'1');
        sudokuGrid.populate(3,7,'*');
        sudokuGrid.populate(3,8,'*');
// 5
        sudokuGrid.populate(4,0,'9');
        sudokuGrid.populate(4,1,'3');
        sudokuGrid.populate(4,2,'8');
        sudokuGrid.populate(4,3,'5');
        sudokuGrid.populate(4,4,'1');
        sudokuGrid.populate(4,5,'7');
        sudokuGrid.populate(4,6,'2');
        sudokuGrid.populate(4,7,'4');
        sudokuGrid.populate(4,8,'6');
// 6
        sudokuGrid.populate(5,0,'*');
        sudokuGrid.populate(5,1,'*');
        sudokuGrid.populate(5,2,'7');
        sudokuGrid.populate(5,3,'6');
        sudokuGrid.populate(5,4,'*');
        sudokuGrid.populate(5,5,'2');
        sudokuGrid.populate(5,6,'*');
        sudokuGrid.populate(5,7,'*');
        sudokuGrid.populate(5,8,'*');
// 7
        sudokuGrid.populate(6,0,'*');
        sudokuGrid.populate(6,1,'*');
        sudokuGrid.populate(6,2,'*');
        sudokuGrid.populate(6,3,'9');
        sudokuGrid.populate(6,4,'*');
        sudokuGrid.populate(6,5,'*');
        sudokuGrid.populate(6,6,'*');
        sudokuGrid.populate(6,7,'*');
        sudokuGrid.populate(6,8,'*');
// 8
        sudokuGrid.populate(7,0,'*');
        sudokuGrid.populate(7,1,'*');
        sudokuGrid.populate(7,2,'*');
        sudokuGrid.populate(7,3,'*');
        sudokuGrid.populate(7,4,'*');
        sudokuGrid.populate(7,5,'5');
        sudokuGrid.populate(7,6,'6');
        sudokuGrid.populate(7,7,'*');
        sudokuGrid.populate(7,8,'*');
// 9
        sudokuGrid.populate(8,0,'7');
        sudokuGrid.populate(8,1,'*');
        sudokuGrid.populate(8,2,'4');
        sudokuGrid.populate(8,3,'*');
        sudokuGrid.populate(8,4,'6');
        sudokuGrid.populate(8,5,'*');
        sudokuGrid.populate(8,6,'8');
        sudokuGrid.populate(8,7,'*');
        sudokuGrid.populate(8,8,'9');

    }

    private boolean checkRow(int row) {
        boolean retVal = false;
        int count = 0;
        int one, two, three, four, five, six, seven, eight, nine;
        one=two=three=four=five=six=seven=eight=nine=0;
        for (int i=0; i<9; i++) {
            // row
            if (sudokuGrid.extract(row, i) != '*') {
                count++;
                switch (sudokuGrid.extract(row, i)) {
                    case '1':
                        if (one == 0) {
                            one = 1;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '2':
                        if (two == 0) {
                            two = 2;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '3':
                        if (three == 0) {
                            three = 3;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '4':
                        if (four == 0) {
                            four = 4;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '5':
                        if (five == 0) {
                            five = 5;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '6':
                        if (six == 0) {
                            six = 6;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '7':
                        if (seven == 0) {
                            seven = 7;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '8':
                        if (eight == 0) {
                            eight = 8;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '9':
                        if (nine == 0) {
                            nine = 9;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    default:
                        break;
                }
            }
        } // loop done

        // check that row contains all nine numbers
        if (one != 0  && two!=0 && three!=0 && four!=0 && five!=0 && six!=0 && seven!=0 && eight!=0 && nine!=0) {
            retVal = true;
        }

        return retVal;
    }

    private boolean checkColumn(int col) {
        boolean retVal = false;
        int count = 0;
        int one, two, three, four, five, six, seven, eight, nine;
        one=two=three=four=five=six=seven=eight=nine=0;
        for (int i=0; i<9; i++) {
            // row
            if (sudokuGrid.extract(i, col) != '*') {
                count++;
                switch (sudokuGrid.extract(i, col)) {
                    case '1':
                        if (one == 0) {
                            one = 1;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '2':
                        if (two == 0) {
                            two = 2;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '3':
                        if (three == 0) {
                            three = 3;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '4':
                        if (four == 0) {
                            four = 4;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '5':
                        if (five == 0) {
                            five = 5;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '6':
                        if (six == 0) {
                            six = 6;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '7':
                        if (seven == 0) {
                            seven = 7;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '8':
                        if (eight == 0) {
                            eight = 8;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    case '9':
                        if (nine == 0) {
                            nine = 9;
                        } else {
                            throw new RuntimeException("Fatal, cannot replicate integers");
                        }
                        break;
                    default:
                        break;
                }
            }
        } // loop done

        // check that column contains all nine numbers
        if (one != 0  && two!=0 && three!=0 && four!=0 && five!=0 && six!=0 && seven!=0 && eight!=0 && nine!=0) {
            retVal = true;
        }

        return retVal;
    }
}
