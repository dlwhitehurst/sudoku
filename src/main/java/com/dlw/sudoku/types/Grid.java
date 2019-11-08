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

package com.dlw.sudoku.types;

public class Grid {

    /**
     * The data structure
     */
    protected char[][] theGrid;

    /**
     * Depth of grid in rows
     */
    protected int rows;

    /**
     * Width of grid in rows
     */
    protected int cols;


    /**
     * Default Class constructor
     */
    public Grid() {} // default

    /**
     * Class constructor with sizing arguments
     * @param rows
     * @param cols
     */
    public Grid(int rows,int cols) {
        theGrid = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * fill a coordinate position row, col with a char
     */
    public void populate(int r, int c, char a) {
        theGrid[r][c] = a;
    }

    /**
     * get a char for coordinate position row, col
     * @param r
     * @param c
     * @return
     */
    public char extract(int r, int c) {
        return new Character(theGrid[r][c]);
    }

    /**
     * FIll all spots with a char
     * @param x
     */
    public void fill(char x) {
        for(int i = 0; i < theGrid.length; ++i) {
            for(int j = 0; j < theGrid[i].length; ++j) {
                theGrid[i][j] = x;
            }
        }
    }

    /**
     * Print the columns by rows
     */
    public void printGrid() {
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                char x = theGrid[i][j];
                System.out.print(x);
                System.out.print("     ");
            }
            System.out.println("\n");
        }
    }

    public char[][] getTheGrid() {
        return theGrid;
    }

    public void setTheGrid(char[][] theGrid) {
        this.theGrid = theGrid;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

}
