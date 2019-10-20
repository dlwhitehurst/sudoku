package com.dlw.sudoku;

public class SudokuColumn extends LinearNine {

    private boolean one = false;
    private boolean two = false;
    private boolean three = false;
    private boolean four = false;
    private boolean five = false;
    private boolean six = false;
    private boolean seven = false;
    private boolean eight = false;
    private boolean nine = false;


    public boolean isEightColumn() {
        boolean retVal = false;
        int count = 0;
        if (this.isNotEmpty()) {
            for(int j = 0; j < super.size(); ++j) {
                // check each placeholder
                String tmp = new String(String.valueOf(theLinearNine[j]));
                if (tmp.contains("1") ||
                        tmp.contains("2") ||
                        tmp.contains("3") ||
                        tmp.contains("4") ||
                        tmp.contains("5") ||
                        tmp.contains("6") ||
                        tmp.contains("7") ||
                        tmp.contains("8") ||
                        tmp.contains("9")){
                    count++;
                }
            }
            if (count == 8) {
                retVal = true;
            }
        }
        return retVal;
    }

    public void populateMissingNumber(int missing) {
        // add missing number in empty position
        for(int j = 0; j < this.size(); ++j) {
            if (this.getTheLinearNine()[j] == '*') {
                this.theLinearNine[j] = new String(Integer.toString(missing)).charAt(0);
            }
        }
    }

    public int getNinthNumber() {
        int number = 0;
        for(int j = 0; j < this.size(); ++j) {
            switch (this.getTheLinearNine()[j]) {
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

    private boolean isNotEmpty() {
        boolean retVal = false;
        for(int j = 0; j < super.size(); ++j) {
            // check each placeholder
            String tmp = new String(String.valueOf(theLinearNine[j]));
            if (!tmp.equals("")){
                retVal = true;
            }
        }
        return retVal;
    }

}
