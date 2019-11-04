package com.dlw.sudoku.types;

public class GridNine extends Grid {

    private int sizeNine = 9;

    protected boolean one = false;
    protected boolean two = false;
    protected boolean three = false;
    protected boolean four = false;
    protected boolean five = false;
    protected boolean six = false;
    protected boolean seven = false;
    protected boolean eight = false;
    protected boolean nine = false;

    protected int emptyRow;
    protected int emptyCol;

    public GridNine(int rows, int cols) {
        //int rows, cols;
        //rows = 3;
        //cols = 3;
        theGrid = new char[rows][cols]; // always 3x3
    }

    public void settMissingNumberIndices() {
        char value = '*';

        for (int j = 0; j < 3; ++j) {
            if (this.getTheGrid()[0][j] == '*') {
                this.emptyRow = 0;
                this.emptyCol = j;
            } else {
                value = this.getTheGrid()[0][j];
                setNumberBoolean(value);
            }
            if (this.getTheGrid()[1][j] == '*') {
                this.emptyRow = 1;
                this.emptyCol = j;
            } else {
                value = this.getTheGrid()[1][j];
                setNumberBoolean(value);
            }
            if (this.getTheGrid()[2][j] == '*') {
                this.emptyRow = 2;
                this.emptyCol = j;
            } else {
                value = this.getTheGrid()[2][j];
                setNumberBoolean(value);
            }
        }
    }

    public int getOneMissingNumber() {
        int number = 0;
        final int sizeNine = 9;

        if (!this.one) {
            number = 1;
        }
        if (!this.two) {
            number = 2;
        }
        if (!this.three) {
            number = 3;
        }
        if (!this.four) {
            number = 4;
        }
        if (!this.five) {
            number = 5;
        }
        if (!this.six) {
            number = 6;
        }
        if (!this.seven) {
            number = 7;
        }
        if (!this.eight) {
            number = 8;
        }
        if (!this.nine) {
            number = 9;
        }

        return number;
    }

    public int getEmptyRow() {
        return emptyRow;
    }

    public void setEmptyRow(int emptyRow) {
        this.emptyRow = emptyRow;
    }

    public int getEmptyCol() {
        return emptyCol;
    }

    public void setEmptyCol(int emptyCol) {
        this.emptyCol = emptyCol;
    }

    private void setNumberBoolean(char value) {
        for (int j = 0; j < sizeNine; ++j) {
            switch (value) {
                case '1':
                    this.one = true;
                    break;
                case '2':
                    this.two = true;
                    break;
                case '3':
                    this.three = true;
                    break;
                case '4':
                    this.four = true;
                    break;
                case '5':
                    this.five = true;
                    break;
                case '6':
                    this.six = true;
                    break;
                case '7':
                    this.seven = true;
                    break;
                case '8':
                    this.eight = true;
                    break;
                case '9':
                    this.nine = true;
                    break;
                default:
                    break;
            }
        }

    }
}
