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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinearNineTests {

    @Test
    @DisplayName("Verify Holds Eight")
   void isEightCount() {
        LinearNine linearNine = new LinearNine();
        linearNine.getTheLinearNine()[0] = ' ';
        linearNine.getTheLinearNine()[1] = '2';
        linearNine.getTheLinearNine()[2] = '3';
        linearNine.getTheLinearNine()[3] = '4';
        linearNine.getTheLinearNine()[4] = '5';
        linearNine.getTheLinearNine()[5] = '6';
        linearNine.getTheLinearNine()[6] = '7';
        linearNine.getTheLinearNine()[7] = '8';
        linearNine.getTheLinearNine()[8] = '9';

        assertTrue(linearNine.isEightCount(), "The char array holds eight numbers only!");
    }

    @Test
    @DisplayName("Verify Holds Eight")
    void isSevenCount() {
        LinearNine linearNine = new LinearNine();
        linearNine.getTheLinearNine()[0] = ' ';
        linearNine.getTheLinearNine()[1] = ' ';
        linearNine.getTheLinearNine()[2] = '3';
        linearNine.getTheLinearNine()[3] = '4';
        linearNine.getTheLinearNine()[4] = '5';
        linearNine.getTheLinearNine()[5] = '6';
        linearNine.getTheLinearNine()[6] = '7';
        linearNine.getTheLinearNine()[7] = '8';
        linearNine.getTheLinearNine()[8] = '9';

        assertTrue(linearNine.isSevenCount(), "The char array holds seven numbers only!");
    }

}
