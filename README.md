# sudoku

This README describes this Java project and my strategy for solving a Sudoku puzzle using 
a computer instead of a human. This is a fun exercise for me to 1) solve the puzzle 2) and
then see how fast I can solve the puzzle afterward by refactoring.

## Strategy

My strategy is to first provide data structures for the puzzle and operations on the puzzle.
So far, I'm ready to change the data structures, to make them better, but I'm going to wait
until the puzzle is solved. To solve the puzzle, I must identify and understand the rules.

## Solving Techniques

The Sudoku Java class has a public solve method. This method has a do-while not-puzzleSolved() 
loop. Inside this loop will be a series of checks and moves. If a check proves a move, a number
is added and the method tries the next check. At the end of the loop, the puzzle is checked for
solution and if not complete, the process repeats itself.

1. Rows with 8 numbers.
2. Columns with 8 numbers.
3. Blocks with 8 numbers.
4. Check rows with 7 numbers.
5. Check columns with 7 numbers.
6. Cross-hatching checks (3 rows or columns)
