package puzzle;

import java.io.FileNotFoundException;
import java.util.*;

public class SudokuGame {

    protected int dimension;
    ArrayList<Character> symbols;
    PuzzleParser pp;
    protected char[][] originalBoard;
    protected char[][] currentBoard;
    protected char[][] solvedBoard;

    /**
     * Constructor for sudoku game, takes a file path which is where the txt file containing the puzzle to be solved is.
     * Creates an instance of PuzzleParser which reads in the file. Also checks for invalid symbols/boards.
     * @param filename
     * @throws Exception
     */
    public SudokuGame(String filename) throws PuzzleException, FileNotFoundException {

        this.pp = new PuzzleParser(filename);
        this.dimension = this.pp.getDimension();
        originalBoard = new char[dimension][dimension];
        currentBoard = new char[dimension][dimension];
        solvedBoard = new char[dimension][dimension];

        this.originalBoard = buildBoardFromFile(filename);
        this.currentBoard = buildBoardFromFile(filename);
        this.solvedBoard = buildBoardFromFile(filename);
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
     * default constructor from a gameboard
     * only used for testing
     * @param
     * @throws Exception
     */
    protected SudokuGame() throws PuzzleException {
    }

    /**
     * Prints a board
     * @param board
     * @return
     */

    public String printBoard(char[][] board){
        StringBuilder message = new StringBuilder("The board is: \n");
        for(int i = 0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
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
    protected boolean checkValidBoard() {
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

    /**
     * This method makes a deep copy of a board (a two dimensional array of char values)
     * @param inBoard
     * @return
     */
    protected char[][] copyBoard(char[][] inBoard){
        if(inBoard == null){
            return null;
        }
        char[][] resultBoard = new char[this.dimension][this.dimension];
        for(int i = 0; i < this.dimension; i++){
            for(int j = 0; j < this.dimension; j++){
                resultBoard[i][j] = inBoard[i][j];
            }
        }
        return resultBoard;
    }

    /**
     * This method updates a value in a game board at r, c to v
     * @param v
     * @param r
     * @param c
     */
    protected void makeSelection(char v, int r, int c){
        currentBoard[r][c] = v;
    }
}