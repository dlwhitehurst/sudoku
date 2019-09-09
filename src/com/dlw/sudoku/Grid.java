package com.dlw.sudoku;

public class Grid {

    char[][] theGrid;
    int rows;
    int cols;

    /**
     * Class constructor
     */
    Grid(int rows,int cols) {
        theGrid = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * fill a coordinate position row, col with a char
     */
    void populate(int r, int c, char a) {
        theGrid[r][c] = a;
    }

    /**
     * get a char for coordinate position row, col
     * @param r
     * @param c
     * @return
     */
    char extract(int r, int c) {
        return new Character(theGrid[r][c]);
    }

    /**
     * FIll all spots with a char
     * @param x
     */
    void fill(char x) {
        for(int i = 0; i < theGrid.length; ++i) {
            for(int j = 0; j < theGrid[i].length; ++j) {
                theGrid[i][j] = x;
            }
        }
    }

    /**
     * Print the columns by rows
     */
    void printGrid() {
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                char x = theGrid[i][j];
                System.out.print(x);
                System.out.print("     ");
            }
            System.out.println("\n");
        }
    }
}
