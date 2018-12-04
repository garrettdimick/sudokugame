package puzzle;

import org.junit.Test;
import static org.junit.Assert.*;

public class HugeSolverTest {


    @Test
    public void nextValuesTest() {

        System.out.println(hs.nextValues());
    }

    @Test
    public void reduceListTest() {
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
        this.currentBoard = board;
        this.dimension = 9;
        this.symbols = ['1', '2', '3', '4', '5', '6', '7', '8', '9'];
        SudokuSolver hs = new HugeSolver(sg);
        assertEquals(hs.reduceList(sg.symbols, 0, 2),[2]);
    }

    @Test
    public void updateCountTest() {
        char[][] board = {
                {'2', '-', '3', '1'},
                {'1', '3', '-', '4'},
                {'3', '1', '4', '-'},
                {'-', '2', '1', '3'}

        };
        SudokuGame sg = new SudokuGame();
        this.currentBoard = board;
        this.dimension = 9;
        this.symbols = ['1', '2', '3', '4'];
        SudokuSolver hs = new HugeSolver(sg);
        hs.updateCount('4');
        assertEquals(hs.appearances.get('4'), 3);
    }
}