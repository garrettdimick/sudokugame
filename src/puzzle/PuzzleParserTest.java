package puzzle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import puzzle.PuzzleParser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class PuzzleParserTest {

    @Test
    public void getBoardFromFileTest() {
        // tested in Application
    }

    @Test
    public void validSymbolsTest() throws FileNotFoundException{
        PuzzleParser puzPars = new PuzzleParser("puzzles/Puzzle-9x9-0001.txt");
        ArrayList<Character> symbols = new ArrayList<>();
        symbols.add('1');
        symbols.add('2');
        symbols.add('3');
        symbols.add('4');
        symbols.add('5');
        symbols.add('6');
        symbols.add('7');
        symbols.add('8');
        symbols.add('9');

        Assertions.assertEquals(puzPars.validSymbols(symbols), true);
    }

    @Test
    public void invalidSymbolsTest() throws FileNotFoundException {
        PuzzleParser puzPars = new PuzzleParser("puzzles/Puzzle-9x9-0001.txt");
        ArrayList<Character> symbols = new ArrayList<>();
        symbols.add('1');
        symbols.add('2');
        symbols.add('3');
        symbols.add('&');
        symbols.add('5');
        symbols.add('6');
        symbols.add('7');
        symbols.add('8');
        symbols.add('9');

        assertEquals(puzPars.validSymbols(symbols), false);
    }

    @Test
    public void validShapeTest() throws FileNotFoundException {
        PuzzleParser puzPars = new PuzzleParser("puzzles/Puzzle-9x9-0001.txt");
        int dim = 4;
        assertEquals(puzPars.validShape(dim), true);
    }

    @Test
    public void invalidShapeTest() throws FileNotFoundException {
        PuzzleParser puzPars = new PuzzleParser("puzzles/Puzzle-9x9-0001.txt");
        int dim = 12;
        assertEquals(puzPars.validShape(dim), false);
    }
}