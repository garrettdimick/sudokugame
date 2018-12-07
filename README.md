# sudokugame
## Improvements  
- Added a Graphical User Interface to play the game. 
- Adding additional features and functionality to the interface should be relatively simple due to the utilization of a 
Model View Presenter pattern.
  - The sudoku.fxml file provides a passive view, i.e. which information is displayed to a user.
  - The Controller class connects the view and the model, which in this case is an SudokuGame and a SudokuSolver. 
- Refactored the solver class into one class to reduce amount of code. 
  - Two classes felt like overkill to me when the use of the class will be simple for this application.    
- Added improved unit testing including making the unit testing more thorough.
