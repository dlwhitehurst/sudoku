package com.dlw.sudoku.types;

public class LinearNine {


    private char[] theLinearNine;
    private int nine = 9;

    /**
     * Class constructor
     */
    public LinearNine() {
        theLinearNine = new char[nine];
    }

    public int size() {
        return theLinearNine.length;
    }

    public void fill(int index, char x) {
        theLinearNine[index] = x;
    }

    public char[] getTheLinearNine() {
        return theLinearNine;
    }

    public void setTheLinearNine(char[] theLinearNine) {
        this.theLinearNine = theLinearNine;
    }

    private void testLoad() {
        for(int j = 0; j < theLinearNine.length; ++j) {
            char x = String.valueOf(j+1).charAt(0);
            theLinearNine[j] = x;
        }
    }

    public static void main(String[] args) {
        LinearNine row = new LinearNine();
        row.testLoad();
        System.out.println("The row is length = " + row.size());
        for(int j = 0; j < row.size(); ++j) {
            System.out.print(row.getTheLinearNine()[j]);
        }

    }

}
