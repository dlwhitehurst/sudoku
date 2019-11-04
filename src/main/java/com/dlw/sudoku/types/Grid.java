package com.dlw.sudoku.types;

public class Grid {

    protected char[][] theGrid;
    protected int rows;
    protected int cols;


    /**
     * Class constructor
     */
    public Grid() {} // default
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
