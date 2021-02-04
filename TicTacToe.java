/*
 * Author: Alvin Hsu
 * Data: 1/2/2021
 *
 * File Name: TicTacToe.java
 * Description: This file contains a playable game of TicTacToe. It includes
 * a user interface that can continue play and change players when a game ends.
 * This is simply a simple file that can play TicTacToe.
 */

/* Imports */
import java.util.Scanner;
import java.util.ArrayList;

/*
 * This class contains the function game that represents TicTacToe. It ensures
 * that no spot is double occupied and contains the check if a player has won
 * or not. The class will then see if the users want to continue and who will
 * start first.
 */
public class TicTacToe {
    public static void main(String[] args){
        //Initialization of the board
        String[][] board = new String[3][3];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j <3; j++)
            {
                board[i][j] = " ";
            }
        }
        play(board);
    }

    /**
     * This method plays the game of TicTacToe with user prompts and the
     * overall game.
     *
     * @param board Board is play with
     */
    public static void play(String[][]board){
        //Get player names and who to start
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of player1: ");
        String name1 = scanner.nextLine();
        System.out.print("Name of player2: ");
        String name2 = scanner.nextLine();
        String firstPerson = name1;
        String secondPerson = name2;
        printBoard(board);
        while (true) {
            //First person move
            System.out.print(firstPerson + "'s move: ");
            String move = scanner.nextLine().toLowerCase();

            //Ensure that input is valid
            while (!(validInput(board,move))){
                System.out.println(firstPerson + "'s move: ");
                move = scanner.nextLine().toLowerCase();
            }
            //Update the board
            char move1Row = move.charAt(0);
            char move1Col = move.charAt(1);
            updatePlayer1(board, move1Row, move1Col);
            System.out.println("");
            printBoard(board);
            //Check if is draw
            if (draw(board)){
                //User ask if wants to continue play
                System.out.println("Draw! No one wins!");
                System.out.println("Play again? \n Yes - Continue\n " +
                        "Quit - End\n");
                String action = scanner.nextLine().toLowerCase();

                if (action.equals("yes")){
                    clearBoard(board);
                    System.out.println("Who to go first? Same or Diff?");
                    String newFirst = scanner.nextLine().toLowerCase();
                    if (newFirst.equals("same")){
                        printBoard(board);
                        continue;
                    }
                    else if (newFirst.equals("diff")){
                        String temp = secondPerson;
                        secondPerson = firstPerson;
                        firstPerson = temp;
                        printBoard(board);
                    }
                    continue;
                }
                else if (action.equals("quit")){
                    break;
                }
            }
            //Did first person win?
            if (wonFirst(board)){
                System.out.println(firstCheck(board));
                System.out.println(firstPerson + " wins!");
                System.out.println("Play again? \n Yes - Continue\n " +
                        "Quit - End\n");
                String action = scanner.nextLine().toLowerCase();

                if (action.equals("yes")){
                    clearBoard(board);
                    System.out.println("Who to go first? Loser or Winner?");
                    String newFirst = scanner.nextLine();
                    if (newFirst.equals("loser")){
                        firstPerson = name2;
                        secondPerson = name1;
                        printBoard(board);
                    }
                    else if (newFirst.equals("winner")){
                        firstPerson = name1;
                        secondPerson = name2;
                        printBoard(board);
                    }
                    continue;
                }
                else if (action.equals("quit")){
                    break;
                }
                else {
                    break;
                }
            }
            //Second's person move
            System.out.println(secondPerson + "'s move: ");
            String move2 = scanner.nextLine().toLowerCase();

            //Wait for valid input
            while (!(validInput(board,move2))){
                System.out.println(secondPerson + "'s move: ");
                move2 = scanner.nextLine().toLowerCase();
            }

            //Update board
            char move2Row = move2.charAt(0);
            char move2Col = move2.charAt(1);
            updatePlayer2(board, move2Row, move2Col);
            System.out.println("");
            printBoard(board);

            //Check if second person won
            if (wonSecond(board)){
                System.out.println(secondPerson + " wins!");
                System.out.println("Play again? \n Yes - Continue\n " +
                        "Quit - End\n");
                String action = scanner.nextLine().toLowerCase();

                if (action.equals("yes")){
                    clearBoard(board);
                    System.out.println("Who to go first? Loser or Winner?");
                    String newFirst = scanner.nextLine();
                    if (newFirst.equals("loser")){
                        firstPerson = name1;
                        secondPerson = name2;
                        printBoard(board);
                    }
                    else if (newFirst.equals("winner")){
                        firstPerson = name2;
                        secondPerson = name1;
                        printBoard(board);
                    }
                    continue;
                }
                else if (action.equals("quit")){
                    break;
                }
                else {
                    break;
                }
            }
        }
    }

    /**
     * This method updates the board with player 1's choice of X only if the
     * slot is empty.
     *
     * @param board Board to play with
     * @param Row Row chosen
     * @param Col Column chosen
     */
    public static void updatePlayer1(String[][] board, char Row, int Col){
        Col -= 49;
        switch (Row){
            case 'a':
                if (board[0][Col].equals(" ")){
                    board[0][Col] = "X";
                    break;
                }

            case 'b':
                if (board[1][Col].equals(" ")){
                    board[1][Col] = "X";
                    break;
                }
            case 'c':
                if (board[2][Col].equals(" ")){
                    board[2][Col] = "X";
                    break;
                }
        }
    }

    /**
     * This method updates the board with player 2's choice of O only if the
     * slot is empty.
     *
     * @param board Board to play with
     * @param Row Row chosen
     * @param Col Column chosen
     */
    public static void updatePlayer2(String[][] board, char Row, int Col){
        Col -= 49;
        switch (Row){
            case 'a':
                if (board[0][Col].equals(" ")){
                    board[0][Col] = "O";
                    break;
                }
            case 'b':
                if (board[1][Col].equals(" ")){
                    board[1][Col] = "O";
                    break;
                }
            case 'c':
                if (board[2][Col].equals(" ")){
                    board[2][Col] = "O";
                    break;
                }
        }
    }

    /**
     * This method prints the board in its current state.
     *
     * @param board Board to print
     */
    public static void printBoard(String[][] board){
        System.out.println("   1    2   3");
        System.out.println("A  " + board[0][0] + " | " + board[0][1] +
                "  | " + board[0][2]);
        System.out.println("  ------------");
        System.out.println("B  " + board[1][0] + " | " + board[1][1] +
                "  | " + board[1][2]);
        System.out.println("  ------------");
        System.out.println("C  " + board[2][0] + " | " + board[2][1] +
                "  | " + board[2][2]);

    }

    /**
     * This method checks to see if the first player won the game by checking
     * if it has a connection of 3 X's.
     *
     * @param board Board to check
     * @return true if player1 won, false otherwise
     */
    public static boolean wonFirst(String[][] board){
        for (Integer num : firstCheck(board)){
            if (num == 3) return true;
        }
        return false;
    }

    /**
     * This method will check the number of X's in each possible row and add
     * that number to an arrayList. If an index has a value of 3, that means
     * that there is a connection of 3 and that player won.
     *
     * @param board Board to check
     * @return ArrayList of connection numbers
     */
    public static ArrayList<Integer> firstCheck(String[][] board){
        ArrayList<Integer> list = new ArrayList<>();
        int numRow = board.length;
        int numCol = board[0].length;
        int times = 0;
        //top bottom check
        for (int i = 0; i < numCol; i++){
            if (board[0][i].equals("X")){
                for (int j = 0; j < numRow; j++){
                    if ((board[j][i].equals("X"))){
                        times++;
                    }
                }
                list.add(times);
                times = 0;
            }
        }

        //left right check
        for (int i = 0; i < numRow; i++) {
            if (board[i][0].equals("X")) {
                for (int j = 0; j < numCol; j++) {
                    if ((board[i][j]).equals("X")) {
                        times++;
                    }
                }
                list.add(times);
                times = 0;
            }
        }
        //Left corner to right corner check
        int pos = 0;
        if (board[0][pos].equals("X")) {
            for (int i = 0; i < numRow; i++) {
                if ((board[i][pos]).equals("X")) {
                    times++;
                }
                pos++;
            }
            list.add(times);
            times = 0;
        }
        //Right corner to left corner check
        int pos1 = 2;
        if (board[0][pos1].equals("X")) {
            for (int i = 0; i < numRow; i++) {
                if ((board[i][pos1]).equals("X")) {
                    times++;
                }
                pos1--;
            }
            list.add(times);
        }
        return list;

    }

    /**
     * This method checks to see if the first player won the game by checking
     * if it has a connection of 3 O's.
     *
     * @param board Board to check
     * @return true if player2 won, false otherwise
     */
    public static boolean wonSecond(String[][] board){
        for (Integer num : secondCheck(board)){
            if (num == 3) return true;
        }
        return false;
    }

    /**
     * This method will check the number of O's in each possible row and add
     * that number to an arrayList. If an index has a value of 3, that means
     * that there is a connection of 3 and that player won.
     *
     * @param board Board to check
     * @return ArrayList of connection numbers
     */
    public static ArrayList<Integer> secondCheck(String[][] board){
        ArrayList<Integer> list = new ArrayList<>();
        int numRow = board.length;
        int numCol = board[0].length;
        int times = 0;
        //top bottom check
        for (int i = 0; i < numCol; i++){
            if (board[0][i].equals("O")){
                for (int j = 0; j < numRow; j++){
                    if ((board[j][i].equals("O"))){
                        times++;
                    }
                }
                list.add(times);
                times = 0;
            }
        }

        //left right check
        for (int i = 0; i < numRow; i++) {
            if (board[i][0].equals("O")) {
                for (int j = 0; j < numCol; j++) {
                    if ((board[i][j]).equals("O")) {
                        times++;
                    }
                }
                list.add(times);
                times = 0;
            }
        }
        //Left corner to right corner check
        int pos = 0;
        if (board[0][pos].equals("O")) {
            for (int i = 0; i < numRow; i++) {
                if ((board[i][pos]).equals("O")) {
                    times++;
                }
                pos++;
            }
            list.add(times);
            times = 0;
        }
        //Right corner to left corner check
        int pos1 = 2;
        if (board[0][pos1].equals("O")) {
            for (int i = 0; i < numRow; i++) {
                if ((board[i][pos1]).equals("O")) {
                    times++;
                }
                pos1--;
            }
            list.add(times);
        }
        return list;

    }

    /**
     * This method will clear the board if the users decide to continue play.
     *
     * @param board Board to clear
     */
    public static void clearBoard(String[][]board){
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j <3; j++)
            {
                board[i][j] = " ";
            }
        }
    }

    /**
     * This method checks to if there is draw. A draw is considered when there
     * are no spaces open left and no player has a connection of 3.
     *
     * @param board Board to check
     * @return true if draw, false otherwise.
     */
    public static boolean draw(String[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j].equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method checks to see if the input is valid. If checks the character
     * input and will notify the users if the input is invalid, or the space
     * is occupied.
     *
     * @param board Board to check
     * @param position Position to check
     * @return true if valid position, false otherwise
     */
    public static boolean validInput(String[][]board, String position){
        //Input must be 2 characters
        if (position.length() != 2){
            System.out.println("Invalid Position");
            return false;
        }
        char letter = position.charAt(0);
        char index = position.charAt(1);
        //Change to decimal numbers
        index -= 48;
        letter -= 96;

        try{
            //Index must be within within 0 and 3 (exclusive)
            if (index > 3 || index <= 0) {
                System.out.println("Invalid Position");
                return false;
            }
            //Letter must be within 0 and 3 (exclusive) (A-C changed to 0-3)
            if (letter > 3 || letter <= 0){
                System.out.println("Invalid Position");
                return false;
            }
        }
        catch(Exception e){
            System.out.println("Invalid Position");
            return false;
        }
        index-=1;
        letter-=1;

        //If space if occupied
        if (!(board[letter][index].equals(" "))){
            System.out.println("Space is occupied");
            return false;
        }
        return true;
    }
}
