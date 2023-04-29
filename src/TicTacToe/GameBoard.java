package TicTacToe;


// abstract class

public abstract class GameBoard {
    char defaultGameValue = ' ';
    char[][] createdBoard;   // initialise variable for the gameBoard 2D Array

    // Constructor method - when we initialise an object of the class we create the board
    public GameBoard() {
        createGameBoard(); // create game board when an object initialised

    }

    /*
    1. 'abstract' = This is an abstract method.
    2. 'protected' = The function can be accessed from a class that's inheriting from this current 'GameBoard' class.
    3. 'char[][]' = it has a 2d array return type with characters.
    4. () = no input arguments.
    */
    abstract protected char[][] createGameBoard();


    /*
    1. 'abstract' = This is an abstract method.
    2. 'protected' = The function can be accessed from a class that's inheriting from this current 'GameBoard' class.
    3. 'void' = it has no return type.
    4. (char[][] createdBoard) = arguments are a 2d array of characters
    */
    abstract protected void resetGameBoard();


    public boolean boardisfull() {
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

    //Method to check if there's already a marker in a position someone wants to put their marker on
    public boolean isPositionTaken(int row, int col) {
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
