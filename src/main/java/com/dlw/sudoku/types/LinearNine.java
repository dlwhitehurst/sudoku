package com.dlw.sudoku.types;

public class LinearNine {

    private char[] theLinearNine;
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

    private int rowNo = 0;
    private int colNo = 0;

    private boolean row = false;
    private boolean col = false;


    /**
     * Class constructor
     */
    public LinearNine() {
        theLinearNine = new char[sizeNine];
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

    public boolean isComplete() {
        boolean retVal = true;
        for(int j = 0; j < this.size(); ++j) {
            // check each placeholder
            String tmp = new String(String.valueOf(theLinearNine [j]));
            if (tmp.equals("*")){
                retVal = false;
            }
        }

        return retVal;
    }

    public boolean isSevenCount() {
        boolean retVal = false;
        int count = 0;
        if (this.isNotEmpty()) {
            for(int j = 0; j < size(); ++j) {
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
            if (count == 7) {
                retVal = true;
            }
        }
        return retVal;
    }

    public boolean isEightCount() {
        boolean retVal = false;
        int count = 0;
        if (this.isNotEmpty()) {
            for(int j = 0; j < size(); ++j) {
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
                this.getTheLinearNine()[j] = new String(Integer.toString(missing)).charAt(0);
            }
        }
    }

    public int getOneMissingNumber() {
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

    public boolean isRow() {
        return row;
    }

    public void setRow(boolean row) {
        this.row = row;
    }

    public boolean isCol() {
        return col;
    }

    public void setCol(boolean col) {
        this.col = col;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public int getColNo() {
        return colNo;
    }

    public void setColNo(int colNo) {
        this.colNo = colNo;
    }

    private boolean isNotEmpty() {
        boolean retVal = false;
        for(int j = 0; j < size(); ++j) {
            // check each placeholder
            String tmp = new String(String.valueOf(theLinearNine[j]));
            if (!tmp.equals("")){
                retVal = true;
            }
        }
        return retVal;
    }

    private void setNumberBooleansAllTrue() {
        this.one = true;
        this.two = true;
        this.three = true;
        this.four = true;
        this.five = true;
        this.six = true;
        this.seven = true;
        this.eight = true;
        this.nine = true;
    }

    private void setNumberBooleansAllFalse() {
        this.one = false;
        this.two = false;
        this.three = false;
        this.four = false;
        this.five = false;
        this.six = false;
        this.seven = false;
        this.eight = false;
        this.nine = false;
    }

    public int[] getMissingNumbers() {
        setNumberBooleansAllFalse();
        int[] numbers = new int[9];
        for(int j = 0; j < this.size(); j++) {
            String tmp = new String(String.valueOf(theLinearNine[j]));
            if (tmp.contains("1")) {
                this.one = true;
            }
            if (tmp.contains("2")) {
                this.two = true;
            }
            if (tmp.contains("3")) {
                this.three = true;
            }
            if (tmp.contains("4")) {
                this.four = true;
            }
            if (tmp.contains("5")) {
                this.five = true;
            }
            if (tmp.contains("6")) {
                this.six = true;
            }
            if (tmp.contains("7")) {
                this.seven = true;
            }
            if (tmp.contains("8")) {
                this.eight = true;
            }
            if (tmp.contains("9")) {
                this.nine = true;
            }
        }

        int count = 0;
        if (!this.one) {
            numbers[count] = 1;
            count++;
        }
        if (!this.two) {
            numbers[count] = 2;
            count++;
        }
        if (!this.three) {
            numbers[count] = 3;
            count++;
        }
        if (!this.four) {
            numbers[count] = 4;
            count++;
        }
        if (!this.five) {
            numbers[count] = 5;
            count++;
        }
        if (!this.six) {
            numbers[count] = 6;
            count++;
        }
        if (!this.seven) {
            numbers[count] = 7;
            count++;
        }
        if (!this.eight) {
            numbers[count] = 8;
            count++;
        }
        if (!this.nine) {
            numbers[count] = 9;
            count++;
        }

        return numbers;
    }

    public int[] getColumnIndices() {
        int[] columns = new int[9];
        int count = 0;
        for(int j = 0; j < this.size(); j++) {
            String tmp = new String(String.valueOf(theLinearNine[j]));
            if (tmp.contains("*")) {
                columns[count] = j+1;
                count++;
            }
        }
        return columns;
    }
}
