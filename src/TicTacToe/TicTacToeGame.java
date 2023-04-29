package TicTacToe;


import java.util.Scanner;

public class TicTacToeGame {
    Scanner input = new Scanner(System.in);


    protected TicTacToeBoard myTicTacToeBoard; // create an instance of the 'TicTacToeBoard' Class.
    private final User player1; // private final is used to declare a constant field that can only be set once, either in the constructor or during initialization.
    private final User player2;
    private User currentPlayer;




    public TicTacToeGame(String player1Name, char player1Marker, String player2Name, char player2Marker){
        /**
         * Constructs a new TicTacToeGame object with the given player names and markers.
         * Initializes the game board with a new instance of TicTacToeBoard, and initializes
         * player1 and player2 with new instances of User with the inputted names and markers.
         * Sets the current player to player1.
         */
        this.myTicTacToeBoard = new TicTacToeBoard(); // initialize myTicTacToeBoard with a new instance of TicTacToeBoard
        this.player1 = new User(player1Name, player1Marker); // initialize player1 with a new instance of User with inputted name and marker
        this.player2 = new User(player2Name, player2Marker); // initialize player2 with a new instance of User with inputted name and marker
        this.currentPlayer = this.player1; // set currentPlayer to player1
    }

    public static TicTacToeGame gameSetUp(){
        /**
         * Prompts the user to enter the name and marker of two players, and creates a new TicTacToeGame object with the given player information.
         *
         * @return a TicTacToeGame object with the player information entered by the user.
         */
        Scanner input = new Scanner(System.in);

        System.out.println("Player 1 enter your name:");
        String player1Name = input.nextLine();

        char player1Marker;
        while (true) {
            System.out.println("Player 1 enter your marker (X or O):");
            player1Marker = input.nextLine().charAt(0);
            if (player1Marker == 'X' || player1Marker == 'O') {
                break;
            } else {
                System.out.println("Invalid marker. Please enter either X or O.");
            }
        }

        System.out.println("Player 2 enter your name:");
        String player2Name = input.nextLine();

        char player2Marker;
        while (true) {
            System.out.println("Player 2 enter your marker (X or O):");
            player2Marker = input.nextLine().charAt(0);
            if (player2Marker == 'X' || player2Marker == 'O') {
                if (player2Marker == player1Marker) {
                    System.out.println("Invalid marker. Player 1 already has that marker. Please choose a different marker.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid marker. Please enter either X or O.");
            }
        }

        TicTacToeGame currentGame = new TicTacToeGame(player1Name,player1Marker,player2Name,player2Marker);  // create an object of the 'TicTacToeGame' class to call its methods

        System.out.println("Player 1");
        currentGame.player1.displayUserInfo();

        System.out.println("Player 2");
        currentGame.player2.displayUserInfo();

        return currentGame;
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


    public User getCurrentPlayer(){
        /**
         * Returns the current player who is playing the game.
         *
         * @return The current player object.
         */
        return currentPlayer;
        }

    //Method to switch to the next player
    public void switchPlayer(){
        /**
         * Switches the current player to the other player.
         */
        if(getCurrentPlayer()==player1){
            this.currentPlayer=player2;
        }
        else if(getCurrentPlayer()==player2){
            this.currentPlayer=player1;
        }
    }

    public String makeMove() {
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
    public boolean isGameOver(){
        /**
         * Checks if the TicTacToe game is over by verifying if the board is full or if there is a winner.
         *
         * @return true if the game is over, false otherwise
         */
        if (myTicTacToeBoard.boardisfull() || myTicTacToeBoard.isThereAWinner() !='N'){
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
        gameSetUp().playGame();

    }

}
