// Interface : A contract that specifies the capabilities that a class should provide

package TicTacToe;



// Board interface
public interface Board {
    /**
     * The Board interface represents the game board for a two-player game, such as Tic Tac Toe.
     * It defines methods for displaying the game board, checking if the board is full, and checking
     * if a position on the board is already taken.
     */
    void displayGameBoard();
    boolean isBoardFull();
    boolean isPositionTaken(int row, int col);

}
