package puzzle;

import java.io.FileNotFoundException;
import java.util.*;

public class SudokuGame {

    protected int dimension;
    ArrayList<Character> symbols;
    PuzzleParser pp;
    protected char[][] originalBoard;
    protected char[][] currentBoard;


    /**
     * Constructor for sudoku game, takes a file path which is where the txt file containing the puzzle to be solved is.
     * Creates an instance of PuzzleParser which reads in the file. Also checks for invalid symbols/boards.
     * @param filename
     * @throws Exception
     */
    public SudokuGame(String filename) throws PuzzleException, FileNotFoundException {
        this.pp = new PuzzleParser();
        this.originalBoard = buildBoardFromFile(filename);
        this.currentBoard = this.originalBoard;
        this.dimension = this.pp.dimension;
        if(!this.pp.validShape(this.dimension)){
            throw new PuzzleException(printBoard(this.originalBoard) + "\nInvalid Shape.");
        }
        this.symbols = this.pp.symbols;
        if(!this.pp.validSymbols(this.symbols)){
            throw new PuzzleException("Invalid Symbol Detected.");
        }
        if(checkValidBoard() == false){
            throw new PuzzleException("\n" + printBoard(this.originalBoard) + "Invalid Board Detected.");
        }
    }

    /**
     * default constructor
     * @param
     * @throws Exception
     */
    public SudokuGame() throws Exception {
    }

    /**
     * Prints a board
     * @param board
     * @return
     */

    protected String printBoard(char[][] board){
        StringBuilder message = new StringBuilder();
        for(int i=0;i<this.dimension;i++)
        {
            for(int j=0;j<this.dimension;j++)
            {
                message.append(board[i][j]);
                message.append(" ");
            }
            message.append("\n");
        }
        return message.toString();
    }

    /**
     * Constructs a board from a given file, using the puzzle parser instance
     * @param filename
     * @return
     * @throws FileNotFoundException
     */
    protected char[][] buildBoardFromFile(String filename) throws FileNotFoundException {
        this.originalBoard = pp.getBoardFromFile(filename);
        return originalBoard;
    }

    protected void printSymbols(){
        for(Character i : this.symbols){
            System.out.print(i.toString() + " ");
        }
        System.out.println();
    }

    /**
     * Makes sure a board is valid
     * @return
     */
    private boolean checkValidBoard() {
        for(int i = 0;i<dimension;i++){
            for(int j = 0;j<dimension;j++){
                if(originalBoard[i][j] == '-'){
                    continue;
                }
                if(!symbols.contains(originalBoard[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    protected void makeSelection(char v, int r, int c){
        currentBoard[r][c] = v;
    }
}