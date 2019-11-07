package com.dlw.sudoku.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SudokuUtilityTests {
    @Test
    @DisplayName("Verify getInstance()")
    void getSingleton() {
        Object obj = SudokuUtility.getInstance();
        assertNotNull(obj);
    }

}
