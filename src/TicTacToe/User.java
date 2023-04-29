package TicTacToe;


public class User {

    //Attributes
     private String name;
     private char marker;

    //Constructor
    public User(String name,char marker) {
        // initialise instance variables
        this.name = name;
        this.marker = marker;
    }

    // GETTERS

    /*
    1. 'public' = The function can be accessed from any class.
    2. 'String' = it has a String return type.
    3. () = no input arguments.
    */
    public String getName(){
        return name;
    }


    /*
    1. 'public' = The function can be accessed from any class.
    2. 'char' = it has a characters return type.
    3. () = no input arguments.
    */
    public char getMarker(){
        return marker;
    }


    //SETTERS
    /*
    1. 'public' = The function can be accessed from any class.
    2. 'void' = it has no return type.
    3. (String username) = String input arguments.
    */
    public void setName(String username){
        name = username;
    }

    /*
    1. 'public' = The function can be accessed from any class.
    2. 'void' = it has no return type.
    3. (char usermarker) = character input arguments.
    */
    public void setMarker(char usermarker){

        marker = usermarker;
    }

    /*
    1. 'public' = The function can be accessed from any class.
    2. 'void' = no return type.
    3. () = no input arguments.
    */
    public void displayUserInfo(){
        System.out.println("Name: "+getName()+", Marker: "+getMarker());
    }

    public static void main(String[] args) {

    }

}