package puzzle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Used to create puzzle boards from text files. Can also save a solved puzzle to a text file.
 */
public class PuzzleParser {

    protected int dimension;
    protected ArrayList<Character> symbols = new ArrayList<Character>();

    /**
     * Constructor
     * @param filename
     * @throws FileNotFoundException
     */
    public PuzzleParser(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner s = new Scanner(file);
        int dim = s.nextInt();
        this.dimension = dim;
    }

    public char[][] getBoardFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner s = new Scanner(file);
        int dim = s.nextInt();
        this.dimension = dim;
        for(int i=0;i<dim;i++){
            symbols.add(s.next().charAt(0));
        }
        char[][] board = new char[dim][dim];
        int rCounter = 0;
        int cCounter = 0;
        while (s.hasNext() && rCounter < dim) {
            char val = s.next().charAt(0);
            board[rCounter][cCounter] = val;
            cCounter++;
            if (cCounter == dim) {
                cCounter = 0;
                rCounter++;
            }
        }
        return board;
    }

    public boolean validSymbols(ArrayList<Character> symbolList){
        for(Character i : symbolList){
            if(!Character.isLetterOrDigit(i)){
                return false;
            }
        }
        return true;
    }

    public boolean validShape(int dim){
        if(Arrays.asList(4, 9, 16).contains(dim)){
            return true;
        }
        return false;
    }

    public int getDimension(){
        return this.dimension;
    }
}