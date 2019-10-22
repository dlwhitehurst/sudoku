package com.dlw.sudoku;

import com.dlw.sudoku.types.Grid;
import com.dlw.sudoku.utility.SudokuUtility;

public class Sudoku {

    /**
     * Parent Grid 9x9
     */
    private Grid parent;

    /**
     * Nine block grids 3x3
     */
    private Grid b1;
    private Grid b2;
    private Grid b3;
    private Grid b4;
    private Grid b5;
    private Grid b6;
    private Grid b7;
    private Grid b8;
    private Grid b9;


    /**
     * Blocks complete
     */
    private Boolean stateB1 = false;
    private Boolean stateB2 = false;
    private Boolean stateB3 = false;
    private Boolean stateB4 = false;
    private Boolean stateB5 = false;
    private Boolean stateB6 = false;
    private Boolean stateB7 = false;
    private Boolean stateB8 = false;
    private Boolean stateB9 = false;

    /**
     * Rows complete
     */
    private Boolean stateR1 = false;
    private Boolean stateR2 = false;
    private Boolean stateR3 = false;
    private Boolean stateR4 = false;
    private Boolean stateR5 = false;
    private Boolean stateR6 = false;
    private Boolean stateR7 = false;
    private Boolean stateR8 = false;
    private Boolean stateR9 = false;

    /**
     * Columns complete
     */
    private Boolean stateC1 = false;
    private Boolean stateC2 = false;
    private Boolean stateC3 = false;
    private Boolean stateC4 = false;
    private Boolean stateC5 = false;
    private Boolean stateC6 = false;
    private Boolean stateC7 = false;
    private Boolean stateC8 = false;
    private Boolean stateC9 = false;


    public Sudoku() {
        parent = new Grid(9,9); // 9x9 Sudoku Grid (Needs loading)
        b1 = new Grid(3,3);
        b2 = new Grid(3,3);
        b3 = new Grid(3,3);
        b4 = new Grid(3,3);
        b5 = new Grid(3,3);
        b6 = new Grid(3,3);
        b7 = new Grid(3,3);
        b8 = new Grid(3,3);
        b9 = new Grid(3,3);
    }

    public Grid getParent() {
        return parent;
    }

    public void setParent(Grid parent) {
        this.parent = parent;
    }

    public SudokuRow getRow(int rowNum) {
        int index = rowNum - 1;
        SudokuRow row = new SudokuRow();
        row.fill(0, parent.getTheGrid()[index][0]);
        row.fill(1, parent.getTheGrid()[index][1]);
        row.fill(2, parent.getTheGrid()[index][2]);
        row.fill(3, parent.getTheGrid()[index][3]);
        row.fill(4, parent.getTheGrid()[index][4]);
        row.fill(5, parent.getTheGrid()[index][5]);
        row.fill(6, parent.getTheGrid()[index][6]);
        row.fill(7, parent.getTheGrid()[index][7]);
        row.fill(8, parent.getTheGrid()[index][8]);

        return row;
    }

    public SudokuColumn getColumn(int columnNum) {
        int index = columnNum - 1;
        SudokuColumn column = new SudokuColumn();
        column.fill(0, parent.getTheGrid()[0][index]);
        column.fill(1, parent.getTheGrid()[1][index]);
        column.fill(2, parent.getTheGrid()[2][index]);
        column.fill(3, parent.getTheGrid()[3][index]);
        column.fill(4, parent.getTheGrid()[4][index]);
        column.fill(5, parent.getTheGrid()[5][index]);
        column.fill(6, parent.getTheGrid()[6][index]);
        column.fill(7, parent.getTheGrid()[7][index]);
        column.fill(8, parent.getTheGrid()[8][index]);

        return column;
    }

    public void updateRow(int rowNum, SudokuRow row) {
        int index = rowNum - 1;
        for(int j = 0; j < row.size(); ++j) {
            parent.populate(index ,j,row.getTheLinearNine()[j]);
        }

        // every fix or progress to the puzzle needs this
        SudokuUtility.getInstance().updateBlocks(this);

        // set boolean row complete
        if (row.isComplete()) {
            switch(rowNum) {
                case 1: {
                    this.setStateR1(true);
                    break;
                }
                case 2: {
                    this.setStateR2(true);
                    break;
                }
                case 3: {
                    this.setStateR3(true);
                    break;
                }
                case 4: {
                    this.setStateR4(true);
                    break;
                }
                case 5: {
                    this.setStateR5(true);
                    break;
                }
                case 6: {
                    this.setStateR6(true);
                    break;
                }
                case 7: {
                    this.setStateR7(true);
                    break;
                }
                case 8: {
                    this.setStateR8(true);
                    break;
                }
                case 9: {
                    this.setStateR9(true);
                    break;
                }

                default: {
                    break;
                }
            }
        }

    }

    public void updateColumn(int columnNum, SudokuColumn column) {
        int index = columnNum - 1;
        for(int j = 0; j < column.size(); ++j) {
            parent.populate(j ,index, column.getTheLinearNine()[j]);
        }
        // every fix or progress to the puzzle needs this
        SudokuUtility.getInstance().updateBlocks(this);
        // set boolean column complete

    }

    public void solve() {
        do {
            for (int j = 0; j < 9; ++j) {
                SudokuColumn column = this.getColumn(j + 1);
                if (column.isEightColumn()) {
                    SudokuUtility.getInstance().completeEightColumn(j + 1, this);
                }
            }
        } while (!puzzleComplete());
    }

    private Boolean puzzleComplete() {
        boolean retVal = true;
        for(int j = 0; j < 9; ++j) {
            SudokuRow row = this.getRow(j+1);
            if (!row.isComplete()) {
                retVal = false;
            }
        }
        //return retVal;
        return true;
    }

    public Grid getB1() {
        return b1;
    }

    public void setB1(Grid b1) {
        this.b1 = b1;
    }

    public Grid getB2() {
        return b2;
    }

    public void setB2(Grid b2) {
        this.b2 = b2;
    }

    public Grid getB3() {
        return b3;
    }

    public void setB3(Grid b3) {
        this.b3 = b3;
    }

    public Grid getB4() {
        return b4;
    }

    public void setB4(Grid b4) {
        this.b4 = b4;
    }

    public Grid getB5() {
        return b5;
    }

    public void setB5(Grid b5) {
        this.b5 = b5;
    }

    public Grid getB6() {
        return b6;
    }

    public void setB6(Grid b6) {
        this.b6 = b6;
    }

    public Grid getB7() {
        return b7;
    }

    public void setB7(Grid b7) {
        this.b7 = b7;
    }

    public Grid getB8() {
        return b8;
    }

    public void setB8(Grid b8) {
        this.b8 = b8;
    }

    public Grid getB9() {
        return b9;
    }

    public void setB9(Grid b9) {
        this.b9 = b9;
    }
    public Boolean getStateB1() {
        return stateB1;
    }

    public void setStateB1(Boolean stateB1) {
        this.stateB1 = stateB1;
    }

    public Boolean getStateB2() {
        return stateB2;
    }

    public void setStateB2(Boolean stateB2) {
        this.stateB2 = stateB2;
    }

    public Boolean getStateB3() {
        return stateB3;
    }

    public void setStateB3(Boolean stateB3) {
        this.stateB3 = stateB3;
    }

    public Boolean getStateB4() {
        return stateB4;
    }

    public void setStateB4(Boolean stateB4) {
        this.stateB4 = stateB4;
    }

    public Boolean getStateB5() {
        return stateB5;
    }

    public void setStateB5(Boolean stateB5) {
        this.stateB5 = stateB5;
    }

    public Boolean getStateB6() {
        return stateB6;
    }

    public void setStateB6(Boolean stateB6) {
        this.stateB6 = stateB6;
    }

    public Boolean getStateB7() {
        return stateB7;
    }

    public void setStateB7(Boolean stateB7) {
        this.stateB7 = stateB7;
    }

    public Boolean getStateB8() {
        return stateB8;
    }

    public void setStateB8(Boolean stateB8) {
        this.stateB8 = stateB8;
    }

    public Boolean getStateB9() {
        return stateB9;
    }

    public void setStateB9(Boolean stateB9) {
        this.stateB9 = stateB9;
    }

    public Boolean getStateR1() {
        return stateR1;
    }

    public void setStateR1(Boolean stateR1) {
        this.stateR1 = stateR1;
    }

    public Boolean getStateR2() {
        return stateR2;
    }

    public void setStateR2(Boolean stateR2) {
        this.stateR2 = stateR2;
    }

    public Boolean getStateR3() {
        return stateR3;
    }

    public void setStateR3(Boolean stateR3) {
        this.stateR3 = stateR3;
    }

    public Boolean getStateR4() {
        return stateR4;
    }

    public void setStateR4(Boolean stateR4) {
        this.stateR4 = stateR4;
    }

    public Boolean getStateR5() {
        return stateR5;
    }

    public void setStateR5(Boolean stateR5) {
        this.stateR5 = stateR5;
    }

    public Boolean getStateR6() {
        return stateR6;
    }

    public void setStateR6(Boolean stateR6) {
        this.stateR6 = stateR6;
    }

    public Boolean getStateR7() {
        return stateR7;
    }

    public void setStateR7(Boolean stateR7) {
        this.stateR7 = stateR7;
    }

    public Boolean getStateR8() {
        return stateR8;
    }

    public void setStateR8(Boolean stateR8) {
        this.stateR8 = stateR8;
    }

    public Boolean getStateR9() {
        return stateR9;
    }

    public void setStateR9(Boolean stateR9) {
        this.stateR9 = stateR9;
    }

    public Boolean getStateC1() {
        return stateC1;
    }

    public void setStateC1(Boolean stateC1) {
        this.stateC1 = stateC1;
    }

    public Boolean getStateC2() {
        return stateC2;
    }

    public void setStateC2(Boolean stateC2) {
        this.stateC2 = stateC2;
    }

    public Boolean getStateC3() {
        return stateC3;
    }

    public void setStateC3(Boolean stateC3) {
        this.stateC3 = stateC3;
    }

    public Boolean getStateC4() {
        return stateC4;
    }

    public void setStateC4(Boolean stateC4) {
        this.stateC4 = stateC4;
    }

    public Boolean getStateC5() {
        return stateC5;
    }

    public void setStateC5(Boolean stateC5) {
        this.stateC5 = stateC5;
    }

    public Boolean getStateC6() {
        return stateC6;
    }

    public void setStateC6(Boolean stateC6) {
        this.stateC6 = stateC6;
    }

    public Boolean getStateC7() {
        return stateC7;
    }

    public void setStateC7(Boolean stateC7) {
        this.stateC7 = stateC7;
    }

    public Boolean getStateC8() {
        return stateC8;
    }

    public void setStateC8(Boolean stateC8) {
        this.stateC8 = stateC8;
    }

    public Boolean getStateC9() {
        return stateC9;
    }

    public void setStateC9(Boolean stateC9) {
        this.stateC9 = stateC9;
    }
}
