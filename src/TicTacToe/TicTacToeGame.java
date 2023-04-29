package TicTacToe;


import java.util.Scanner;

public class TicTacToeGame {
    Scanner input = new Scanner(System.in);


    protected TicTacToeBoard myTicTacToeBoard; // create an instance of the 'TicTacToeBoard' Class.
    private final User player1; // private final is used to declare a constant field that can only be set once, either in the constructor or during initialization.
    private final User player2;
    private User currentPlayer;




    public TicTacToeGame(String player1Name, char player1Marker, String player2Name, char player2Marker){
        this.myTicTacToeBoard = new TicTacToeBoard(); // initialize myTicTacToeBoard with a new instance of TicTacToeBoard
        this.player1 = new User(player1Name, player1Marker); // initialize player1 with a new instance of User with inputted name and marker
        this.player2 = new User(player2Name, player2Marker); // initialize player2 with a new instance of User with inputted name and marker
        this.currentPlayer = this.player1; // set currentPlayer to player1
    }


    /*
    1. 'public' = The function can be accessed from any class.
    2. 'void' = it has no return type.
    3. () = no input arguments.
    */
    public String playGame(){
        while (!isGameOver()){
            // Create an object of the TicTacToeBoard

            makeMove();
            myTicTacToeBoard.displayGameBoard();
        }

        char winnerChar = myTicTacToeBoard.isThereAWinner();
        String winnerName;

        if (player1.getMarker() == winnerChar) {
            winnerName = player1.getName();
        }else if (player2.getMarker() == winnerChar) {
            winnerName = player2.getName();
        }else {
            return "No winner this time :(";
        }
        return ("The Winner is " + winnerName + "!!!");

    }

    //Method to play game


    public User getCurrentPlayer(){
        return currentPlayer;
        }

    //Method to switch to the next player
    public void switchPlayer(){
        if(getCurrentPlayer()==player1){
            this.currentPlayer=player2;
        }
        else if(getCurrentPlayer()==player2){
            this.currentPlayer=player1;
        }
    }

    //Method makeMove to plot the current players marker in a location based on row and col num
    public String makeMove() {
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
        if (myTicTacToeBoard.boardisfull() || myTicTacToeBoard.isThereAWinner() !='N'){
            return true;
        }
        return false;
    }

    // Method to check if there is a winner
    //call this after a move is placed




        //Method to reset board-this is called from another func


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Player 1 enter your name:");
        String player1Name = input.nextLine();
        System.out.println("Player 1 enter your marker:");
        char player1Marker = input.next().charAt(0);

        // Consume the newline character left by next()
        input.nextLine();

        System.out.println("Player 2 enter your name:");
        String player2Name = input.nextLine();
        System.out.println("Player 2 enter your marker:");
        char player2Marker = input.next().charAt(0);

        /* validate user input
        if (marker != 'X' && marker != 'O') {
            System.out.println("Invalid marker. Please enter either X or O.");
        */


        TicTacToeGame currentGame = new TicTacToeGame(player1Name,player1Marker,player2Name,player2Marker);  // create an object of the 'TicTacToeGame' class to call its methods

        System.out.println("Player 1");
        currentGame.player1.displayUserInfo();

        System.out.println("Player 2");
        currentGame.player2.displayUserInfo();


        System.out.println(currentGame.playGame());




    }

}
