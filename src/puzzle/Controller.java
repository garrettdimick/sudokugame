package puzzle;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

public class Controller implements Initializable {

    @FXML Button button_one;
    @FXML Button button_two;
    @FXML Button button_three;
    @FXML Button button_four;
    @FXML Button button_five;
    @FXML Button button_six;
    @FXML Button button_seven;
    @FXML Button button_eight;
    @FXML Button button_nine;
    @FXML Button button_A;
    @FXML Button button_B;
    @FXML Button button_C;
    @FXML Button button_D;
    @FXML Button button_E;
    @FXML Button button_F;
    @FXML Button button_G;
    @FXML Button button_solution;
    @FXML Button button_new;
    @FXML Button button_submit;

    @FXML Canvas board_space;

    protected SudokuGame sg;
    protected SudokuSolver solver;
    private static final int SPACING = 1;
    protected int size = 55;
    protected int x_offset = 0;
    protected int y_offset = 0;
    protected int fontSize = 20;
    int player_selection_row = 0;
    int player_selection_col = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            sg = new SudokuGame("puzzles/Puzzle-16x16-0001.txt");
            solver = new SudokuSolver(sg);
            Thread solverThread = new Thread(() -> {
                solver.solveSudoku();
            });
            solverThread.setDaemon(true);
            solverThread.start();

//            solver.solveSudoku();
            sg.originalBoard = sg.copyBoard(sg.currentBoard);

            if(sg.dimension == 4){
                size = 123;
                x_offset = 50;
                y_offset = 75;
                fontSize = 40;
            }
            if(sg.dimension == 9){
                size = 55;
                x_offset = 22;
                y_offset = 35;
            }
            if(sg.dimension == 16){
                size = 30;
                x_offset = 11;
                y_offset = 20;
                fontSize = 14;
            }
        } catch (PuzzleException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        GraphicsContext context = board_space.getGraphicsContext2D();
        drawBoard(context);
    }

    public void drawBoard(GraphicsContext context){
        context.clearRect(0,0,495,495);
        // Draw spaces on the board for the characters
        for(int r = 0; r < sg.dimension;r++){
            for(int c = 0; c < sg.dimension; c++){
                int pos_y = r * size + SPACING;
                int pos_x = c * size + SPACING;
                int w = size - SPACING*2;
                context.setFill(Color.LAVENDER);
                context.fillRoundRect(pos_x, pos_y, w, w, 8, 8);
            }
        }
        context.setStroke(Color.FUCHSIA);
        context.setLineWidth(4);
        context.strokeRoundRect(player_selection_col * size + SPACING, player_selection_row * size + SPACING, size - SPACING * 2, size - SPACING * 2, 8, 8);

        char[][] initialBoard = sg.copyBoard(sg.currentBoard);
        for(int r = 0; r < sg.dimension;r++){
            for(int c = 0; c < sg.dimension; c++){
                int pos_y = r * size + y_offset;
                int pos_x = c * size + x_offset;
                context.setFill(Color.BLACK);
                context.setFont(new Font(fontSize));
                if(initialBoard[r][c] != '-'){
                    context.fillText(initialBoard[r][c] + "", pos_x, pos_y);
                }
            }
        }
    }

    public void boardMouseClicked(){
        board_space.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int mouse_x = (int) event.getX();
                int mouse_y = (int) event.getY();

                player_selection_col = (int) (mouse_x / size);
                player_selection_row = (int) (mouse_y / size);

                drawBoard(board_space.getGraphicsContext2D());
            }
        });
    }

    public void buttonOnePressed(){
        sg.makeSelection('1', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonTwoPressed(){
        sg.makeSelection('2', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonThreePressed(){
        sg.makeSelection('3', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonFourPressed(){
        sg.makeSelection('4', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonFivePressed(){
        sg.makeSelection('5', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonSixPressed(){
        sg.makeSelection('6', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonSevenPressed(){
        sg.makeSelection('7', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonEightPressed(){
        sg.makeSelection('8', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonNinePressed(){
        sg.makeSelection('9', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonAPressed(){
        sg.makeSelection('A', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonBPressed(){
        sg.makeSelection('B', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonCPressed(){
        sg.makeSelection('C', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonDPressed(){
        sg.makeSelection('D', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonEPressed(){
        sg.makeSelection('E', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonFPressed(){
        sg.makeSelection('F', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void buttonGPressed(){
        sg.makeSelection('G', player_selection_row, player_selection_col);
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void solutionButtonPressed(){
        solver.solveSudoku();
        sg.currentBoard = solver.getSudokuGame().solvedBoard;
        drawBoard(board_space.getGraphicsContext2D());
    }

    public void checkSubmissionButtonPressed(){
        solver.solveSudoku();
        char[][] solvedBoard = sg.copyBoard(solver.sg.solvedBoard);
        if(solver.checkAllCellsFilled(sg.currentBoard) && solver.checkComplete(sg.currentBoard, sg.solvedBoard)) {
            validSolutionAlert();
        }
        else{
            invalidSolutionAlert();
        }
    }

    private void invalidSolutionAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Solution");
        alert.setHeaderText("OOPS");
        alert.setContentText("You may want to check for mistakes, it looks like your solution is not valid.");
        alert.showAndWait();
    }

    private void validSolutionAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WINNER!");
        alert.setHeaderText("You did it!");
        alert.setContentText("Congratulations on solving the puzzle!");
        alert.showAndWait();
    }
}
