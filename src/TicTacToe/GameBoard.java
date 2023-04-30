package TicTacToe;


// abstract class

public abstract class GameBoard implements Board {
    char defaultGameValue = ' ';
    char[][] createdBoard;   // initialise variable for the gameBoard 2D Array


    public GameBoard() {
        /**
         This is a constructor method for the GameBoard class.
         It is called when an object of the class is initialized and creates the game board.
         It calls the abstract method createGameBoard() to create the game board.
         */
        createGameBoard();

    }

    /*
    1. 'abstract' = This is an abstract method.
    2. 'protected' = The function can be accessed from a class that's inheriting from this current 'GameBoard' class.
    3. 'char[][]' = it has a 2d array return type with characters.
    4. () = no input arguments.
    */
    /**
     Abstract method to create the game board as a 2D char array.
     @return a 2D char array representing the game board
     */
    abstract protected char[][] createGameBoard();




    /*
    1. 'abstract' = This is an abstract method.
    2. 'protected' = The function can be accessed from a class that's inheriting from this current 'GameBoard' class.
    3. 'void' = it has no return type.
    4. (char[][] createdBoard) = arguments are a 2d array of characters
    */
    /**
     An abstract method that resets the game board. This method is implemented in a subclass to reset the game board specific to that subclass.
     */
    abstract protected void resetGameBoard();


    public boolean isBoardFull() {
        /**
        Checks if the game board is full, i.e., there are no more empty cells to place markers in.
        @return true if the game board is full, false otherwise.
        */
        int numFilled = 0;
        for (int i = 0; i < createdBoard.length; i++) {
            for (int j = 0; j < createdBoard[i].length; j++) {
                if (createdBoard[i][j] != defaultGameValue) {
                    numFilled++;
                }
            }
        }
        int numCells = createdBoard.length * createdBoard[0].length;
        if (numFilled != numCells) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isPositionTaken(int row, int col) {
        /**
        This method checks if a given position on the game board is already taken by a player's marker.
        @param row an integer representing the row position on the game board
        @param col an integer representing the column position on the game board
        @return true if the position is taken, false if it is available
        */
        if (createdBoard[row][col] == ' ') {
            return false;
        }
        else {
            return true;
        }
    }





    /*
    1. 'public' = The function can be accessed from any class.
    2. 'void' = it has no return type.
    3. () = no input arguments.
    */
    public void displayGameBoard() {

       /**
       Displays the current state of the tic-tac-toe board on the console.
       */

        for (int i = 0; i < createdBoard.length; i++) {
            String boardRow = "";
            String rowSep = "";
            for (int j = 0; j < createdBoard[i].length; j++) {
                boardRow = boardRow + "|" + createdBoard[i][j] + "|";
                rowSep += "---";
            }
            if (i == 0) {
                System.out.println(rowSep);
            }
            System.out.println(boardRow);
            System.out.println(rowSep);
        }
    }


    public static void main(String[] args) {
    }

}
