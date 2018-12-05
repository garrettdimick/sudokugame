package puzzle;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class SudokuSolver {
    protected SudokuGame sg;

    public SudokuSolver(SudokuGame game){
        sg = game;
    }

    /**
     * Solves a sudoku puzzle using backtracking.
     * Uses placementAllowed to determine if a value can be placed in that cell.
     * @return true if solved, false if not
     */
    //This method solves the whole puzzle using the other methods defined
    protected boolean solveSudoku() {
        for(int r = 0;r < sg.dimension;r++){
            for(int c = 0; c < sg.dimension;c++){
                if(sg.solvedBoard[r][c] == '-'){
                    for(Character i : sg.symbols) {
                        char v = i.charValue();
                        if (placementAllowed(r, c, v)) {
                            sg.solvedBoard[r][c] = v;
                            if (solveSudoku()) {
                                return true;
                            } else {
                                sg.solvedBoard[r][c] = '-';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if a value is in the given row r
     */
    protected boolean inRow(int r, char v){
        for(int i=0;i<sg.dimension;i++) {
            if (sg.solvedBoard[r][i] == v) {
                return true;
            }
        }
        return false;
    }
    /**
     * Check if a value is in the column
     */
    protected boolean inColumn(int c, char v){
        for(int i=0;i<sg.dimension;i++){
            if(sg.solvedBoard[i][c] == v){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a value is in a Box
     */
    protected boolean inBox(int r, int c, char v){
        int boxSize = (int) Math.sqrt(sg.dimension);
        int row = r - r % boxSize;
        int col = c - c % boxSize;
        for(int i = row; i < row + boxSize; i++){
            for(int j = col; j < col + boxSize; j++){
                if(sg.solvedBoard[i][j] == v){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a value can be placed in a cell by calling inRow, inBox, and inColumn
     */
    protected boolean placementAllowed(int r, int c, char v){
        return !inRow(r, v) && !inColumn(c, v) && !inBox(r,c,v);
    }

    public SudokuGame getSudokuGame(){
        return this.sg;
    }

    protected boolean checkAllCellsFilled(char[][] board){
        for(int r = 0;r < sg.dimension; r++){
            for(int c = 0; c < sg.dimension; c++){
                if(board[r][c] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean checkComplete(char[][] board1, char[][]board2){
        if(board1 == null){
            return (board2 == null);
        }
        if(board2 == null){
            return false;
        }
        if(board1.length != board2.length){
            return false;
        }
        for(int i = 0; i < board1.length; i++){
            if(!Arrays.equals(board1[i], board2[i])){
                return false;
            }
        }
        return true;
    }
}
