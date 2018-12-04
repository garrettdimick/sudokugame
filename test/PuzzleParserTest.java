package puzzle;

import org.junit.Test;
import static org.junit.Assert.*;

public class PuzzleParserTest {


    @Test
    public void getBoardFromFileTest() {
        // tested in Main
    }

    @Test
    public void saveSolutionToFileTest() {
        // tested in Main
    }

    @Test
    public void validSymbolsTest() {
        ArrayList<Character> symbols = ['1', '2', '3', '4', '5', '6', '7', '8', '9'];
        assertEquals(validSymbols(symbols), true);
    }

    @Test
    public void invalidSymbolsTest(){
        ArrayList<Character> symbols = ['1', '2', '3', '?', '5', '6', '7', '8', '9'];
        assertEquals(validSymbols(symbols), false);
    }

    @Test
    public void validShapeTest() {
        int dim = 4;
        assertEquals(validShape(dim), true);
    }

    @Test
    public void invalidShapeTest(){
        int dim = 12;
        assertEquals(validShape(dim), false);
    }
}
