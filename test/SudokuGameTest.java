package puzzle;
import org.junit.Test;
import static org.junit.Assert.*;

class SudokuGameTest {

    @Test
    void testPrintBoard() throws Exception {
        SudokuGame sg = new SudokuGame();
        sg.dimension = 9;
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

        sg.currentBoard = board;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        sg.printBoard(sg.currentBoard);
        String expectedOutput = "4 9 - 1 3 6 7 - 8\n" +
                "- 6 3 5 - - - 9 -\n" +
                "5 - - - 2 9 3 6 4\n" +
                "- 2 - 3 1 - - 4 -\n" +
                "- 7 4 - - - 2 1 -\n" +
                "- - 1 - 6 4 - 8 -\n" +
                "1 8 6 9 - - - 2 5\n" +
                "- 4 - - 5 1 8 3 -\n" +
                "3 - 9 4 8 - - 7 -"
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintSymbols() {
        SudokuGame sg1= new SudokuGame();
        sg1.symbols = ['1', '2', '3', '4'];
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        sg1.printSymbols();
        String expectedOutput = "1, 2, 3, 4";
        assertEquals(expectedOutput, outContent.toString());
    }
}