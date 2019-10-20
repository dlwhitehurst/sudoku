package com.dlw.sudoku;

class Sudoku {

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

    Sudoku() {
        parent = new Grid(9,9); // 9x9 Sudoku Grid (Pre-loaded)
        b1 = new Grid(3,3);
        b2 = new Grid(3,3);
        b3 = new Grid(3,3);
        b4 = new Grid(3,3);
        b5 = new Grid(3,3);
        b6 = new Grid(3,3);
        b7 = new Grid(3,3);
        b8 = new Grid(3,3);
        b9 = new Grid(3,3);

        loadParent(); // load parent
        updateBlocks(); // load the 3x3s from parent (call as needed)
        //solve();
        //ConsoleUtility.getInstance().printPuzzle(parent);
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
        row.fill(0, parent.theGrid[index][0]);
        row.fill(1, parent.theGrid[index][1]);
        row.fill(2, parent.theGrid[index][2]);
        row.fill(3, parent.theGrid[index][3]);
        row.fill(4, parent.theGrid[index][4]);
        row.fill(5, parent.theGrid[index][5]);
        row.fill(6, parent.theGrid[index][6]);
        row.fill(7, parent.theGrid[index][7]);
        row.fill(8, parent.theGrid[index][8]);

        return row;
    }

    public void updateRow(int rowNum, SudokuRow row) {
        int index = rowNum - 1;
        for(int j = 0; j < row.size(); ++j) {
            parent.populate(index ,j,row.theLinearNine[j]);
        }
        updateBlocks();
    }

    public void solve() {
        do {
            // solve
        } while (!checkPuzzle());
    }

    private Boolean checkPuzzle() {
        return true;
    }

    private void updateBlocks() {
        // 1
        b1.populate(0,0, parent.extract(0,0));
        b1.populate(0,1, parent.extract(0,1));
        b1.populate(0,2, parent.extract(0,2));
        b1.populate(1,0, parent.extract(1,0));
        b1.populate(1,1, parent.extract(1,1));
        b1.populate(1,2, parent.extract(1,2));
        b1.populate(2,0, parent.extract(2,0));
        b1.populate(2,1, parent.extract(2,1));
        b1.populate(2,2, parent.extract(2,2));

        // 2
        b2.populate(0,0, parent.extract(0,3));
        b2.populate(0,1, parent.extract(0,4));
        b2.populate(0,2, parent.extract(0,5));
        b2.populate(1,0, parent.extract(1,3));
        b2.populate(1,1, parent.extract(1,4));
        b2.populate(1,2, parent.extract(1,5));
        b2.populate(2,0, parent.extract(2,3));
        b2.populate(2,1, parent.extract(2,4));
        b2.populate(2,2, parent.extract(2,5));

        //3
        b3.populate(0,0, parent.extract(0,6));
        b3.populate(0,1, parent.extract(0,7));
        b3.populate(0,2, parent.extract(0,8));
        b3.populate(1,0, parent.extract(1,6));
        b3.populate(1,1, parent.extract(1,7));
        b3.populate(1,2, parent.extract(1,8));
        b3.populate(2,0, parent.extract(2,6));
        b3.populate(2,1, parent.extract(2,7));
        b3.populate(2,2, parent.extract(2,8));

        // 4
        b4.populate(0,0, parent.extract(3,0));
        b4.populate(0,1, parent.extract(3,1));
        b4.populate(0,2, parent.extract(3,2));
        b4.populate(1,0, parent.extract(4,0));
        b4.populate(1,1, parent.extract(4,1));
        b4.populate(1,2, parent.extract(4,2));
        b4.populate(2,0, parent.extract(5,0));
        b4.populate(2,1, parent.extract(5,1));
        b4.populate(2,2, parent.extract(5,2));

        // 5
        b5.populate(0,0, parent.extract(3,3));
        b5.populate(0,1, parent.extract(3,4));
        b5.populate(0,2, parent.extract(3,5));
        b5.populate(1,0, parent.extract(4,3));
        b5.populate(1,1, parent.extract(4,4));
        b5.populate(1,2, parent.extract(4,5));
        b5.populate(2,0, parent.extract(5,3));
        b5.populate(2,1, parent.extract(5,4));
        b5.populate(2,2, parent.extract(5,5));

        // 6
        b6.populate(0,0, parent.extract(3,6));
        b6.populate(0,1, parent.extract(3,7));
        b6.populate(0,2, parent.extract(3,8));
        b6.populate(1,0, parent.extract(4,6));
        b6.populate(1,1, parent.extract(4,7));
        b6.populate(1,2, parent.extract(4,8));
        b6.populate(2,0, parent.extract(5,6));
        b6.populate(2,1, parent.extract(5,7));
        b6.populate(2,2, parent.extract(5,8));

        // 7
        b7.populate(0,0, parent.extract(6,0));
        b7.populate(0,1, parent.extract(6,1));
        b7.populate(0,2, parent.extract(6,2));
        b7.populate(1,0, parent.extract(7,0));
        b7.populate(1,1, parent.extract(7,1));
        b7.populate(1,2, parent.extract(7,2));
        b7.populate(2,0, parent.extract(8,0));
        b7.populate(2,1, parent.extract(8,1));
        b7.populate(2,2, parent.extract(8,2));

        // 8
        b8.populate(0,0, parent.extract(6,3));
        b8.populate(0,1, parent.extract(6,4));
        b8.populate(0,2, parent.extract(6,5));
        b8.populate(1,0, parent.extract(7,3));
        b8.populate(1,1, parent.extract(7,4));
        b8.populate(1,2, parent.extract(7,5));
        b8.populate(2,0, parent.extract(8,3));
        b8.populate(2,1, parent.extract(8,4));
        b8.populate(2,2, parent.extract(8,5));

        // 9
        b9.populate(0,0, parent.extract(6,6));
        b9.populate(0,1, parent.extract(6,7));
        b9.populate(0,2, parent.extract(6,8));
        b9.populate(1,0, parent.extract(7,6));
        b9.populate(1,1, parent.extract(7,7));
        b9.populate(1,2, parent.extract(7,8));
        b9.populate(2,0, parent.extract(8,6));
        b9.populate(2,1, parent.extract(8,7));
        b9.populate(2,2, parent.extract(8,8));
    }

    /**
     * Manually load each cell of the Sudoku grid
     */
    private void loadParent() {
// 1
        parent.populate(0,0,'4');
        parent.populate(0,1,'*');
        parent.populate(0,2,'9');
        parent.populate(0,3,'*');
        parent.populate(0,4,'5');
        parent.populate(0,5,'*');
        parent.populate(0,6,'7');
        parent.populate(0,7,'*');
        parent.populate(0,8,'1');
// 2
        parent.populate(1,0,'*');
        parent.populate(1,1,'*');
        parent.populate(1,2,'2');
        parent.populate(1,3,'8');
        parent.populate(1,4,'*');
        parent.populate(1,5,'*');
        parent.populate(1,6,'*');
        parent.populate(1,7,'*');
        parent.populate(1,8,'*');
// 3
        parent.populate(2,0,'*');
        parent.populate(2,1,'*');
        parent.populate(2,2,'*');
        parent.populate(2,3,'*');
        parent.populate(2,4,'*');
        parent.populate(2,5,'1');
        parent.populate(2,6,'*');
        parent.populate(2,7,'*');
        parent.populate(2,8,'*');
// 4
        parent.populate(3,0,'*');
        parent.populate(3,1,'*');
        parent.populate(3,2,'*');
        parent.populate(3,3,'3');
        parent.populate(3,4,'*');
        parent.populate(3,5,'9');
        parent.populate(3,6,'1');
        parent.populate(3,7,'*');
        parent.populate(3,8,'*');
// 5
        parent.populate(4,0,'9');
        parent.populate(4,1,'3');
        parent.populate(4,2,'8');
        parent.populate(4,3,'5');
        parent.populate(4,4,'1');
        parent.populate(4,5,'7');
        parent.populate(4,6,'2');
        parent.populate(4,7,'4');
        parent.populate(4,8,'6');
// 6
        parent.populate(5,0,'*');
        parent.populate(5,1,'*');
        parent.populate(5,2,'7');
        parent.populate(5,3,'6');
        parent.populate(5,4,'*');
        parent.populate(5,5,'2');
        parent.populate(5,6,'*');
        parent.populate(5,7,'*');
        parent.populate(5,8,'*');
// 7
        parent.populate(6,0,'*');
        parent.populate(6,1,'*');
        parent.populate(6,2,'*');
        parent.populate(6,3,'9');
        parent.populate(6,4,'*');
        parent.populate(6,5,'*');
        parent.populate(6,6,'*');
        parent.populate(6,7,'*');
        parent.populate(6,8,'*');
// 8
        parent.populate(7,0,'*');
        parent.populate(7,1,'*');
        parent.populate(7,2,'*');
        parent.populate(7,3,'*');
        parent.populate(7,4,'*');
        parent.populate(7,5,'5');
        parent.populate(7,6,'6');
        parent.populate(7,7,'*');
        parent.populate(7,8,'*');
// 9
        parent.populate(8,0,'7');
        parent.populate(8,1,'1');
        parent.populate(8,2,'4');
        parent.populate(8,3,'2');
        parent.populate(8,4,'6');
        parent.populate(8,5,'3');
        parent.populate(8,6,'8');
        parent.populate(8,7,'*');
        parent.populate(8,8,'9');

    }

}
