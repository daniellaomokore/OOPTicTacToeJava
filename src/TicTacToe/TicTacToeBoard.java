package TicTacToe;

// Inherits from the 'GameBoard' class
public class  TicTacToeBoard  extends GameBoard {

     /*
    1. 'protected' = The method can be called within the same package or subclass(inherited class) of another package.
    2. 'char[][]' = it has a 2d array return type with characters.
    3. () = no input arguments.
    */
     @Override
    protected char[][] createGameBoard() {
         /**
          This method creates a 3x3 char array representing the game board and initializes all its elements to the default value (which is ' ').
          It does so by iterating through each row and column of the array and setting each element to the 'defaultGameValue' variable.
          @return the created 3x3 char array representing the game board
          */

        createdBoard = new char[3][3];   // create the board to have 3 rows & 3 columns

        for(int row=0; row<3; row++){  // for each row - it gets repeated 3 times
            for(int col=0; col<3; col++){  // for each column - it gets repeated 3 times
                createdBoard[row][col] = defaultGameValue;  // set everything to be an empty board
            }
        }
        return createdBoard;

    }


    @Override
    protected void resetGameBoard() {
        /**
         * Resets the game board to its default state with all positions empty.
         *
         * This method iterates over each cell of the game board and sets its value to the default game value,
         * to indicate that the cell is empty and available for a move.
         *
         */
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                createdBoard[row][col] = defaultGameValue;
            }
        }
    }

    public boolean placeMarker(int row, int col, char marker) {
        /**
         * Places a marker on the game board at the specified row and column.
         *
         * @param row    the row to place the marker in
         * @param col    the column to place the marker in
         * @param marker the marker to place on the board ('X' or 'O')
         * @return true if the marker was successfully placed, false otherwise
         */
        createdBoard[row][col] = marker;
        return true;
    }

    public char isThereAWinner() {
        /**
        Determines if there is a winner on the current game board by checking each row, column, and diagonal for matching markers.
        @return The marker of the winning player ('X' or 'O'), or 'N' if there is no winner.
        */
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (createdBoard[row][0] != ' ' && createdBoard[row][0] == (createdBoard[row][1]) && createdBoard[row][1] == (createdBoard[row][2])) {
                return createdBoard[row][0];
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (createdBoard[0][col] != ' ' && createdBoard[0][col] == (createdBoard[1][col]) && createdBoard[1][col] == (createdBoard[2][col])) {
                return createdBoard[0][col];
            }
        }

        // Check diagonals
        if (createdBoard[1][1] != ' ' && ((createdBoard[0][0] == (createdBoard[1][1]) && createdBoard[1][1] == (createdBoard[2][2])) || (createdBoard[0][2] == (createdBoard[1][1]) && createdBoard[1][1] == (createdBoard[2][0])))) {
            return createdBoard[1][1];
        }

        // No winner found
        return 'N';
    }

    /* THIS IS THE ALTERNATIVE WAY TO IMPLEMENT THE CREATEGAMEBOARD METHOD
    @Override
    protected char[][] createGameBoard() {
        int numCols = 3;
        int numRows = 3;
        char[][] board = new char[numCols][numRows];

        //set everything to ' '
        char defaultChar = ' ';
        for(int i = 0; i<numRows; i++)
        {
            for(int j = 0; j<numCols; j++)
            {
                board[i][j] = defaultChar;
            }
        }
        return board;
    }


    */
    public static void main(String[] args) {


    }

}
