package TicTacToe;


import java.util.Scanner;

public class TicTacToeGame {
    Scanner input = new Scanner(System.in);

    private final TicTacToeBoard myTicTacToeBoard; // create an instance of the 'TicTacToeBoard' Class.// private final is used to declare a constant field that can only be set once, either in the constructor or during initialization.
    private final User player1;
    private final User player2;
    private User currentPlayer;



    public TicTacToeGame(){
        /**
         * Constructs a new TicTacToeGame object with the given player names and markers.
         * Initializes the game board with a new instance of TicTacToeBoard, and initializes
         * player1 and player2 with new instances of User with the inputted names and markers.
         * Sets the current player to player1.
         */

        myTicTacToeBoard = new TicTacToeBoard(); // initialize myTicTacToeBoard with a new instance of TicTacToeBoard
        player1 = getPlayer1Info();
        player2 = getPlayer2Info();
        currentPlayer = player1;
    }


    private User getPlayerInfo(int playerNumber, char markerAlreadyTaken) {
        /**
         * Prompts the user to enter the name and marker of a player, and returns a new User object with the entered information.
         *
         * @param playerNumber the number of the player being prompted (1 or 2)
         * @param playerMarkerTaken the marker that has already been taken by the other player
         * @return a User object with the player information entered by the user.
         */
        Scanner input = new Scanner(System.in);

        System.out.println("Enter player " + playerNumber + "'s name:");
        String playerName = input.nextLine();

        char playerMarker;
        while (true) {
            System.out.println("Enter player " + playerNumber + "'s marker (X or O):");
            playerMarker = input.nextLine().charAt(0);
            if (playerMarker == 'X' || playerMarker == 'O') {
                if (playerMarker != markerAlreadyTaken) {
                    break;
                } else {
                    System.out.println("Invalid marker. Player " + playerNumber + " already has that marker. Please choose a different marker.");
                }
            } else {
                System.out.println("Invalid marker. Please enter either X or O.");
            }
        }

        return new User(playerName, playerMarker);
    }

    private User getPlayer1Info() {
        /**
         * Prompts the user to enter the name and marker of the first player, and returns a new User object with the entered information.
         *
         * @return a User object with the player information entered by the user.
         */
        return getPlayerInfo(1, ' ');
    }

    private User getPlayer2Info() {
        /**
         * Prompts the user to enter the name and marker of the second player, and returns a new User object with the entered information.
         *
         * @param player1 the first player, used to ensure that player 2's marker is different
         * @return a User object with the player information entered by the user.
         */
        return getPlayerInfo(2, player1.getMarker());
    }




    /*
    1. 'public' = The function can be accessed from any class.
    2. 'void' = it has no return type.
    3. () = no input arguments.
    */
    public void playGame() {
        /**
         * This method allows players to play a game of Tic Tac Toe until a winner is found or the game is tied. It prompts each
         * player to make a move and displays the game board after each move. Once the game is over, it determines the winner
         * and displays their name. It also prompts the user to play again or exit the program.
         */

        while (!isGameOver()) {
            makeMove();
            myTicTacToeBoard.displayGameBoard();
        }

        char winnerChar = myTicTacToeBoard.isThereAWinner();
        String winnerName = null;

        if (player1.getMarker() == winnerChar) {
            winnerName = player1.getName();
        } else if (player2.getMarker() == winnerChar) {
            winnerName = player2.getName();
        } else {
            System.out.println("No winner this time :(");
        }
        System.out.println("The Winner is " + winnerName + "!!!");
        System.out.println("Would you like to play again? (y/n)");
        String answer = input.nextLine();

        while (!answer.equals("y") && !answer.equals("n")) {
            System.out.println("Invalid input, please try again.");
            answer = input.nextLine();
        }

        if (answer.equals("n")) {
            System.out.println("Okay, See ya later!");
            System.exit(0); // exits the program with a status code of 0 (success)
        } else {
            System.out.println("Starting a new game...");
            myTicTacToeBoard.resetGameBoard();
            playGame();

        }


    }


    private User getCurrentPlayer(){
        /**
         * Returns the current player who is playing the game.
         *
         * @return The current player object.
         */
        return currentPlayer;
        }

    //Method to switch to the next player
    private void switchPlayer(){
        /**
         * Switches the current player to the other player.
         */
        if(getCurrentPlayer()==player1){
            currentPlayer=player2;
        }
        else if(getCurrentPlayer()==player2){
            currentPlayer=player1;
        }
    }

    private String makeMove() {
        /**
         * Prompts the current player to select a location on the game board to place their marker.
         * Returns a message indicating whether the move was successful.
         *
         * @return A string message indicating whether the move was successful.
         */
        int row, col;

        while (true) {
            System.out.println(currentPlayer.getName() + " select the row and column you want to put your marker:");
            row = input.nextInt();
            col = input.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input! Please enter a number between 0 and 2.");
            } else if (myTicTacToeBoard.isPositionTaken(row, col)) {
                System.out.println("Sorry, this position is already taken. Please choose a different space.");
            } else {
                System.out.println(String.format("You have chosen row %d, column %d.", row, col));
                break;
            }
        }

        myTicTacToeBoard.placeMarker(row, col, currentPlayer.getMarker());
        switchPlayer();
        return "Your marker has been placed.";
    }

    //Method to check if board is full/is game over -this is called from another func
    private boolean isGameOver(){
        /**
         * Checks if the TicTacToe game is over by verifying if the board is full or if there is a winner.
         *
         * @return true if the game is over, false otherwise
         */
        if (myTicTacToeBoard.isBoardFull() || myTicTacToeBoard.isThereAWinner() !='N'){
            return true;
        }
        return false;
    }




    public static void main(String[] args) {

    }

}
