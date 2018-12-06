package puzzle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {

    @Test
    void testInRow() throws PuzzleException {
        char[][] board = {
                {'4', '9', '-', '1', '3', '6', '7', '-', '8'},
                {'-', '6', '3', '5', '-', '-', '-', '9', '-'},
                {'5', '-', '-', '-', '2', '9', '3', '6', '4'},
                {'-', '2', '-', '3', '1', '-', '-', '4', '-'},
                {'-', '7', '4', '-', '-', '-', '2', '1', '-'},
                {'-', '-', '1', '-', '6', '4', '-', '8', '-'},
                {'1', '8', '6', '9', '-', '-', '-', '2', '5'},
                {'-', '4', '-', '-', '5', '1', '8', '3', '-'},
                {'3', '-', '9', '4', '8', '-', '-', '7', '-'}
        };

        SudokuGame sg = new SudokuGame();
        sg.dimension = 9;
        sg.solvedBoard = sg.copyBoard(board);
        SudokuSolver solver = new SudokuSolver(sg);
        assertTrue(solver.inRow(0,'4'));
        assertTrue(solver.inRow(0,'9'));
        assertTrue(solver.inRow(0,'1'));
        assertTrue(solver.inRow(0,'3'));
        assertTrue(solver.inRow(0,'7'));
        assertTrue(solver.inRow(0,'8'));
        assertFalse(solver.inRow(0,'2'));


    }

    @Test
    void testInColumn() throws PuzzleException{
        char[][] board = {
                {'4', '9', '-', '1', '3', '6', '7', '-', '8'},
                {'-', '6', '3', '5', '-', '-', '-', '9', '-'},
                {'5', '-', '-', '-', '2', '9', '3', '6', '4'},
                {'-', '2', '-', '3', '1', '-', '-', '4', '-'},
                {'-', '7', '4', '-', '-', '-', '2', '1', '-'},
                {'-', '-', '1', '-', '6', '4', '-', '8', '-'},
                {'1', '8', '6', '9', '-', '-', '-', '2', '5'},
                {'-', '4', '-', '-', '5', '1', '8', '3', '-'},
                {'3', '-', '9', '4', '8', '-', '-', '7', '-'}
        };

        SudokuGame sg = new SudokuGame();
        sg.dimension = 9;
        sg.solvedBoard = sg.copyBoard(board);
        SudokuSolver solver = new SudokuSolver(sg);
        assertTrue(solver.inColumn(1,'9'));
        assertTrue(solver.inColumn(1,'6'));
        assertTrue(solver.inColumn(1,'2'));
        assertTrue(solver.inColumn(1,'7'));
        assertTrue(solver.inColumn(1,'8'));
        assertTrue(solver.inColumn(1,'4'));
        assertFalse(solver.inColumn(1,'1'));

    }

    @Test
    void testInBox() throws PuzzleException{
        char[][] board = {
                {'4', '9', '-', '1', '3', '6', '7', '-', '8'},
                {'-', '6', '3', '5', '-', '-', '-', '9', '-'},
                {'5', '-', '-', '-', '2', '9', '3', '6', '4'},
                {'-', '2', '-', '3', '1', '-', '-', '4', '-'},
                {'-', '7', '4', '-', '-', '-', '2', '1', '-'},
                {'-', '-', '1', '-', '6', '4', '-', '8', '-'},
                {'1', '8', '6', '9', '-', '-', '-', '2', '5'},
                {'-', '4', '-', '-', '5', '1', '8', '3', '-'},
                {'3', '-', '9', '4', '8', '-', '-', '7', '-'}
        };

        SudokuGame sg = new SudokuGame();
        sg.dimension = 9;
        sg.solvedBoard = sg.copyBoard(board);
        SudokuSolver solver = new SudokuSolver(sg);
        assertTrue(solver.inBox(0,0,'4'));
        assertTrue(solver.inBox(0,0,'9'));
        assertTrue(solver.inBox(0,0,'6'));
        assertTrue(solver.inBox(0,0,'3'));
        assertTrue(solver.inBox(0,0,'5'));
        assertFalse(solver.inBox(0,0,'r'));
    }

    @Test
    void testPlacementAllowed() throws PuzzleException{
        char[][] board = {
                {'4', '9', '-', '1', '3', '6', '7', '-', '8'},
                {'-', '6', '3', '5', '-', '-', '-', '9', '-'},
                {'5', '-', '-', '-', '2', '9', '3', '6', '4'},
                {'-', '2', '-', '3', '1', '-', '-', '4', '-'},
                {'-', '7', '4', '-', '-', '-', '2', '1', '-'},
                {'-', '-', '1', '-', '6', '4', '-', '8', '-'},
                {'1', '8', '6', '9', '-', '-', '-', '2', '5'},
                {'-', '4', '-', '-', '5', '1', '8', '3', '-'},
                {'3', '-', '9', '4', '8', '-', '-', '7', '-'}
        };

        SudokuGame sg = new SudokuGame();
        sg.dimension = 9;
        sg.solvedBoard = sg.copyBoard(board);
        SudokuSolver solver = new SudokuSolver(sg);
        assertTrue(solver.placementAllowed(0, 2, '2'));
        assertFalse(solver.placementAllowed(0, 2, '1'));

    }

    @Test
    void testCheckAllCellsFilled() throws PuzzleException{
        char[][] board = {
                {'4', '9', '-', '1', '3', '6', '7', '-', '8'},
                {'-', '6', '3', '5', '-', '-', '-', '9', '-'},
                {'5', '-', '-', '-', '2', '9', '3', '6', '4'},
                {'-', '2', '-', '3', '1', '-', '-', '4', '-'},
                {'-', '7', '4', '-', '-', '-', '2', '1', '-'},
                {'-', '-', '1', '-', '6', '4', '-', '8', '-'},
                {'1', '8', '6', '9', '-', '-', '-', '2', '5'},
                {'-', '4', '-', '-', '5', '1', '8', '3', '-'},
                {'3', '-', '9', '4', '8', '-', '-', '7', '-'}
        };

        SudokuGame sg = new SudokuGame();
        sg.dimension = 9;
        SudokuSolver solver = new SudokuSolver(sg);
        assertFalse(solver.checkAllCellsFilled(board));
    }
}