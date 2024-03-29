/*
 * Copyright (c) 2019. David L. Whitehurst
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dlw.sudoku;

import com.dlw.sudoku.types.Grid;
import com.dlw.sudoku.types.GridNine;

import com.dlw.sudoku.types.LinearNine;
import com.dlw.sudoku.utility.ConsoleUtility;
import com.dlw.sudoku.utility.SudokuUtility;

public class Sudoku {

    /**
     * Parent Grid 9x9
     */
    private Grid parent;

    /**
     * Nine block grids 3x3
     */
    private GridNine b1;
    private GridNine b2;
    private GridNine b3;
    private GridNine b4;
    private GridNine b5;
    private GridNine b6;
    private GridNine b7;
    private GridNine b8;
    private GridNine b9;

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
        b1 = new GridNine(3,3);
        b2 = new GridNine(3,3);
        b3 = new GridNine(3,3);
        b4 = new GridNine(3,3);
        b5 = new GridNine(3,3);
        b6 = new GridNine(3,3);
        b7 = new GridNine(3,3);
        b8 = new GridNine(3,3);
        b9 = new GridNine(3,3);
    }

    public Grid getParent() {
        return parent;
    }

    public void setParent(Grid parent) {
        this.parent = parent;
    }

    public LinearNine getRow(int rowNum) {
        int index = rowNum - 1;
        LinearNine row = new LinearNine();
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

    public LinearNine getColumn(int columnNum) {
        int index = columnNum - 1;
        LinearNine column = new LinearNine();
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

    public void updateRow(int rowNum, LinearNine row) {
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

    public void updateColumn(int columnNum, LinearNine column) {
        int index = columnNum - 1;
        for(int j = 0; j < column.size(); ++j) {
            parent.populate(j ,index, column.getTheLinearNine()[j]);
        }
        // every fix or progress to the puzzle needs this
        SudokuUtility.getInstance().updateBlocks(this);
        // set boolean column complete

        // set boolean column complete
        if (column.isComplete()) {
            switch(columnNum) {
                case 1: {
                    this.setStateC1(true);
                    break;
                }
                case 2: {
                    this.setStateC2(true);
                    break;
                }
                case 3: {
                    this.setStateC3(true);
                    break;
                }
                case 4: {
                    this.setStateC4(true);
                    break;
                }
                case 5: {
                    this.setStateC5(true);
                    break;
                }
                case 6: {
                    this.setStateC6(true);
                    break;
                }
                case 7: {
                    this.setStateC7(true);
                    break;
                }
                case 8: {
                    this.setStateC8(true);
                    break;
                }
                case 9: {
                    this.setStateC9(true);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    public void solve() {
        int count = 1;
        boolean status = false;
        do {

            // check each column for eight count ... resolve
            checkForEightColumns();

            // check each row for eight count ... resolve
            checkForEightRows();

            // check each block for eight blocks ... resolve
            checkForEightBlocks();

            // check each column if 7-length ... resolve if possible
            checkForSevenColumns();

            // check each row if 7-length ... resolve if possible
            checkForSevenRows();

            // cross-hatch all numbers, all directions ... resolve if possible
            for (int i=1; i<10; i++) {
                checkCrossHatchRowsOneToThree(i);
                checkCrossHatchRowsFourToSix(i);
                checkCrossHatchRowsSevenToNine(i);
                checkCrossHatchColumnsOneToThree(i);
                checkCrossHatchColumnsFourToSix(i);
                checkCrossHatchRowsSevenToNine(i);
            }

            count++;
            if (count == 2) {
                status = true;
            }

        } while (!puzzleComplete());
        //} while (!status);

    }

    public GridNine getB1() {
        return b1;
    }

    public void setB1(GridNine b1) {
        this.b1 = b1;
        this.parent.getTheGrid()[0][0] = b1.getTheGrid()[0][0];
        this.parent.getTheGrid()[0][1] = b1.getTheGrid()[0][1];
        this.parent.getTheGrid()[0][2] = b1.getTheGrid()[0][2];
        this.parent.getTheGrid()[1][0] = b1.getTheGrid()[1][0];
        this.parent.getTheGrid()[1][1] = b1.getTheGrid()[1][1];
        this.parent.getTheGrid()[1][2] = b1.getTheGrid()[1][2];
        this.parent.getTheGrid()[2][0] = b1.getTheGrid()[2][0];
        this.parent.getTheGrid()[2][1] = b1.getTheGrid()[2][1];
        this.parent.getTheGrid()[2][2] = b1.getTheGrid()[2][2];
    }

    public GridNine getB2() {
        return b2;
    }

    public void setB2(GridNine b2) {
        this.b2 = b2;
        this.parent.getTheGrid()[0][3] = b2.getTheGrid()[0][0];
        this.parent.getTheGrid()[0][4] = b2.getTheGrid()[0][1];
        this.parent.getTheGrid()[0][5] = b2.getTheGrid()[0][2];
        this.parent.getTheGrid()[1][3] = b2.getTheGrid()[1][0];
        this.parent.getTheGrid()[1][4] = b2.getTheGrid()[1][1];
        this.parent.getTheGrid()[1][5] = b2.getTheGrid()[1][2];
        this.parent.getTheGrid()[2][3] = b2.getTheGrid()[2][0];
        this.parent.getTheGrid()[2][4] = b2.getTheGrid()[2][1];
        this.parent.getTheGrid()[2][5] = b2.getTheGrid()[2][2];
    }

    public GridNine getB3() {
        return b3;
    }

    public void setB3(GridNine b3) {
        this.b3 = b3;
        this.parent.getTheGrid()[0][6] = b3.getTheGrid()[0][0];
        this.parent.getTheGrid()[0][7] = b3.getTheGrid()[0][1];
        this.parent.getTheGrid()[0][8] = b3.getTheGrid()[0][2];
        this.parent.getTheGrid()[1][6] = b3.getTheGrid()[1][0];
        this.parent.getTheGrid()[1][7] = b3.getTheGrid()[1][1];
        this.parent.getTheGrid()[1][8] = b3.getTheGrid()[1][2];
        this.parent.getTheGrid()[2][6] = b3.getTheGrid()[2][0];
        this.parent.getTheGrid()[2][7] = b3.getTheGrid()[2][1];
        this.parent.getTheGrid()[2][8] = b3.getTheGrid()[2][2];
    }

    public GridNine getB4() {
        return b4;
    }

    public void setB4(GridNine b4) {
        this.b4 = b4;
        this.parent.getTheGrid()[3][0] = b4.getTheGrid()[0][0];
        this.parent.getTheGrid()[3][1] = b4.getTheGrid()[0][1];
        this.parent.getTheGrid()[3][2] = b4.getTheGrid()[0][2];
        this.parent.getTheGrid()[4][0] = b4.getTheGrid()[1][0];
        this.parent.getTheGrid()[4][1] = b4.getTheGrid()[1][1];
        this.parent.getTheGrid()[4][2] = b4.getTheGrid()[1][2];
        this.parent.getTheGrid()[5][0] = b4.getTheGrid()[2][0];
        this.parent.getTheGrid()[5][1] = b4.getTheGrid()[2][1];
        this.parent.getTheGrid()[5][2] = b4.getTheGrid()[2][2];
    }

    public GridNine getB5() {
        return b5;
    }

    public void setB5(GridNine b5) {
        this.b5 = b5;
        this.parent.getTheGrid()[3][3] = b5.getTheGrid()[0][0];
        this.parent.getTheGrid()[3][4] = b5.getTheGrid()[0][1];
        this.parent.getTheGrid()[3][5] = b5.getTheGrid()[0][2];
        this.parent.getTheGrid()[4][3] = b5.getTheGrid()[1][0];
        this.parent.getTheGrid()[4][4] = b5.getTheGrid()[1][1];
        this.parent.getTheGrid()[4][5] = b5.getTheGrid()[1][2];
        this.parent.getTheGrid()[5][3] = b5.getTheGrid()[2][0];
        this.parent.getTheGrid()[5][4] = b5.getTheGrid()[2][1];
        this.parent.getTheGrid()[5][5] = b5.getTheGrid()[2][2];
    }

    public GridNine getB6() {
        return b6;
    }

    public void setB6(GridNine b6) {
        this.b6 = b6;
        this.parent.getTheGrid()[3][6] = b6.getTheGrid()[0][0];
        this.parent.getTheGrid()[3][7] = b6.getTheGrid()[0][1];
        this.parent.getTheGrid()[3][8] = b6.getTheGrid()[0][2];
        this.parent.getTheGrid()[4][6] = b6.getTheGrid()[1][0];
        this.parent.getTheGrid()[4][7] = b6.getTheGrid()[1][1];
        this.parent.getTheGrid()[4][8] = b6.getTheGrid()[1][2];
        this.parent.getTheGrid()[5][6] = b6.getTheGrid()[2][0];
        this.parent.getTheGrid()[5][7] = b6.getTheGrid()[2][1];
        this.parent.getTheGrid()[5][8] = b6.getTheGrid()[2][2];
    }

    public GridNine getB7() {
        return b7;
    }

    public void setB7(GridNine b7) {
        this.b7 = b7;
        this.parent.getTheGrid()[6][0] = b7.getTheGrid()[0][0];
        this.parent.getTheGrid()[6][1] = b7.getTheGrid()[0][1];
        this.parent.getTheGrid()[6][2] = b7.getTheGrid()[0][2];
        this.parent.getTheGrid()[7][0] = b7.getTheGrid()[1][0];
        this.parent.getTheGrid()[7][1] = b7.getTheGrid()[1][1];
        this.parent.getTheGrid()[7][2] = b7.getTheGrid()[1][2];
        this.parent.getTheGrid()[8][0] = b7.getTheGrid()[2][0];
        this.parent.getTheGrid()[8][1] = b7.getTheGrid()[2][1];
        this.parent.getTheGrid()[8][2] = b7.getTheGrid()[2][2];
    }

    public GridNine getB8() {
        return b8;
    }

    public void setB8(GridNine b8) {
        this.b8 = b8;
        this.parent.getTheGrid()[6][3] = b8.getTheGrid()[0][0];
        this.parent.getTheGrid()[6][4] = b8.getTheGrid()[0][1];
        this.parent.getTheGrid()[6][5] = b8.getTheGrid()[0][2];
        this.parent.getTheGrid()[7][3] = b8.getTheGrid()[1][0];
        this.parent.getTheGrid()[7][4] = b8.getTheGrid()[1][1];
        this.parent.getTheGrid()[7][5] = b8.getTheGrid()[1][2];
        this.parent.getTheGrid()[8][3] = b8.getTheGrid()[2][0];
        this.parent.getTheGrid()[8][4] = b8.getTheGrid()[2][1];
        this.parent.getTheGrid()[8][5] = b8.getTheGrid()[2][2];
    }

    public GridNine getB9() {
        return b9;
    }

    public void setB9(GridNine b9) {
        this.b9 = b9;
        this.parent.getTheGrid()[6][6] = b9.getTheGrid()[0][0];
        this.parent.getTheGrid()[6][7] = b9.getTheGrid()[0][1];
        this.parent.getTheGrid()[6][8] = b9.getTheGrid()[0][2];
        this.parent.getTheGrid()[7][6] = b9.getTheGrid()[1][0];
        this.parent.getTheGrid()[7][7] = b9.getTheGrid()[1][1];
        this.parent.getTheGrid()[7][8] = b9.getTheGrid()[1][2];
        this.parent.getTheGrid()[8][6] = b9.getTheGrid()[2][0];
        this.parent.getTheGrid()[8][7] = b9.getTheGrid()[2][1];
        this.parent.getTheGrid()[8][8] = b9.getTheGrid()[2][2];
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

    private void checkCrossHatchRowsOneToThree(int number) {
        // check and fix if possible
        LinearNine row1 = this.getRow(1);
        LinearNine row2 = this.getRow(2);
        LinearNine row3 = this.getRow(3);

    }

    private void checkCrossHatchRowsFourToSix(int number) {
        // check and fix if possible
        LinearNine row4 = this.getRow(4);
        LinearNine row5 = this.getRow(5);
        LinearNine row6 = this.getRow(6);

    }

    private void checkCrossHatchRowsSevenToNine(int number) {
        // check and fix if possible
        LinearNine row7 = this.getRow(7);
        LinearNine row8 = this.getRow(8);
        LinearNine row9 = this.getRow(9);

    }

    private void checkCrossHatchColumnsOneToThree(int number) {
        // check and fix if possible
        LinearNine col1 = this.getColumn(1);
        LinearNine col2 = this.getColumn(2);
        LinearNine col3 = this.getColumn(3);

    }

    private void checkCrossHatchColumnsFourToSix(int number) {
        // check and fix if possible
        LinearNine col4 = this.getColumn(4);
        LinearNine col5 = this.getColumn(5);
        LinearNine col6 = this.getColumn(6);

    }

    private void checkCrossHatchColumnsSevenToNine(int number) {
        // check and fix if possible
        LinearNine col7 = this.getColumn(7);
        LinearNine col8 = this.getColumn(8);
        LinearNine col9 = this.getColumn(9);

    }

    private void checkForSevenRows() {
        for (int j = 0; j < 9; ++j) {
            LinearNine row = this.getRow(j + 1);
            if (row.isSevenCount()) {
                ConsoleUtility.getInstance().printFoundSevenRow(j+1);
                SudokuUtility.getInstance().tryFixSevenRow(j + 1, this);
            }
        }
    }

    private void checkForSevenColumns() {
        for (int j = 0; j < 9; ++j) {
            LinearNine column = this.getColumn(j + 1);
            if (column.isSevenCount()) {
                ConsoleUtility.getInstance().printFoundSevenColumn(j+1);
                SudokuUtility.getInstance().tryFixSevenColumn(j + 1, this);
            }
        }
    }

    private void checkForEightRows() {
        for (int j = 0; j < 9; ++j) {
            LinearNine row = this.getRow(j + 1);
            if (row.isEightCount()) {
                ConsoleUtility.getInstance().printFoundEightRow(j+1);
                SudokuUtility.getInstance().completeEightRow(j + 1, this);
            }
        }
    }

    private void checkForEightColumns() {
        for (int j = 0; j < 9; ++j) {
            LinearNine column = this.getColumn(j + 1);
            if (column.isEightCount()) {
                ConsoleUtility.getInstance().printFoundEightColumn(j+1);
                SudokuUtility.getInstance().completeEightColumn(j + 1, this);
            }
        }
    }

    private void checkForEightBlocks() {
        // Block 1
        if (SudokuUtility.getInstance().isEightBlock(this.getB1())) {
            ConsoleUtility.getInstance().printFoundEightBlock(1);
            SudokuUtility.getInstance().completeEightBlock(1, this);
        }
        // Block 2
        if (SudokuUtility.getInstance().isEightBlock(this.getB2())) {
            ConsoleUtility.getInstance().printFoundEightBlock(2);
            SudokuUtility.getInstance().completeEightBlock(2, this);
        }
        // Block 3
        if (SudokuUtility.getInstance().isEightBlock(this.getB3())) {
            ConsoleUtility.getInstance().printFoundEightBlock(3);
            SudokuUtility.getInstance().completeEightBlock(3, this);
        }
        // Block 4
        if (SudokuUtility.getInstance().isEightBlock(this.getB4())) {
            ConsoleUtility.getInstance().printFoundEightBlock(4);
            SudokuUtility.getInstance().completeEightBlock(4, this);
        }
        // Block 5
        if (SudokuUtility.getInstance().isEightBlock(this.getB5())) {
            ConsoleUtility.getInstance().printFoundEightBlock(5);
            SudokuUtility.getInstance().completeEightBlock(5, this);
        }
        // Block 6
        if (SudokuUtility.getInstance().isEightBlock(this.getB6())) {
            ConsoleUtility.getInstance().printFoundEightBlock(6);
            SudokuUtility.getInstance().completeEightBlock(6, this);
        }
        // Block 7
        if (SudokuUtility.getInstance().isEightBlock(this.getB7())) {
            ConsoleUtility.getInstance().printFoundEightBlock(7);
            SudokuUtility.getInstance().completeEightBlock(7, this);
        }
        // Block 8
        if (SudokuUtility.getInstance().isEightBlock(this.getB8())) {
            ConsoleUtility.getInstance().printFoundEightBlock(8);
            SudokuUtility.getInstance().completeEightBlock(8, this);
        }
        // Block 9
        if (SudokuUtility.getInstance().isEightBlock(this.getB9())) {
            ConsoleUtility.getInstance().printFoundEightBlock(9);
            SudokuUtility.getInstance().completeEightBlock(9, this);
        }
    }

    private Boolean puzzleComplete() {
        boolean retVal = true;
        for(int j = 0; j < 9; ++j) {
            LinearNine row = this.getRow(j+1);
            if (!row.isComplete()) {
                retVal = false;
            }
        }
        //return retVal;
        return true;
    }

}
