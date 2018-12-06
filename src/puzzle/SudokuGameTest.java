package puzzle;

import org.junit.jupiter.api.Test;
import puzzle.PuzzleParser;
import puzzle.SudokuGame;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

class SudokuGameTest {

    @Test
    void testPrintBoard() throws Exception {


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
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.out.print(sg.printBoard(board));
        String expectedOutput = "The board is: \n" +
                "4 9 - 1 3 6 7 - 8 \n" +
                "- 6 3 5 - - - 9 - \n" +
                "5 - - - 2 9 3 6 4 \n" +
                "- 2 - 3 1 - - 4 - \n" +
                "- 7 4 - - - 2 1 - \n" +
                "- - 1 - 6 4 - 8 - \n" +
                "1 8 6 9 - - - 2 5 \n" +
                "- 4 - - 5 1 8 3 - \n" +
                "3 - 9 4 8 - - 7 - \n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintSymbols() throws PuzzleException {
        SudokuGame sg1= new SudokuGame();
        sg1.symbols = new ArrayList<>();
        sg1.symbols.add('1');
        sg1.symbols.add('2');
        sg1.symbols.add('3');
        sg1.symbols.add('4');
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        sg1.printSymbols();
        String expectedOutput = "1 2 3 4 \n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testCopyBoard() throws PuzzleException{
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

        SudokuGame sg2 = new SudokuGame();
        sg2.dimension = 9;
        char[][]board2;
        board2 = sg2.copyBoard(board);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                assertEquals(board[i][j], board2[i][j]);
            }
        }
    }

    @Test
    void testMakeSelection() throws PuzzleException{
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

        SudokuGame sg3 = new SudokuGame();
        sg3.dimension = 9;
        sg3.currentBoard = sg3.copyBoard(board);
        assertEquals('-', sg3.currentBoard[0][2]);
        sg3.makeSelection('2', 0, 2);
        assertEquals('2', sg3.currentBoard[0][2]);
    }
}