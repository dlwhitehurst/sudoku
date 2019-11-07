package com.dlw.sudoku.utility;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsoleUtilityTests {

    @Test
    @DisplayName("Verify getInstance()")
    void getSingleton() {
        Object obj = ConsoleUtility.getInstance();
        assertNotNull(obj);
    }
}
