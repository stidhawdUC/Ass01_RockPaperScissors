import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String playerOne = "";
        String playerTwo = "";
        boolean gameOver = false;
        String playAgain = "";

        String playerOneIntro = "Player One Wins:";
        String playerTwoIntro = "Player Two Wins:";
        String playerTiesIntro = "Player Ties:";
        int playerOneWins = 0;
        int playerTwoWins = 0;
        int playerTies = 0;



        do {
            boolean done = false;
            System.out.print("Player One, choose your weapon." +
                    "\n [R P S]: ");
            do {
                playerOne = in.nextLine();
                if (playerOne.equalsIgnoreCase("R")
                        || playerOne.equalsIgnoreCase("P")
                        || playerOne.equalsIgnoreCase("S"))
                    done = true;
                else
                    System.out.print(playerOne + " isn't an acceptable play. Try again." +
                            "\nType R, P or S [R P S]: ");
            } while (!done);

            done = false;
            System.out.print("Player Two, choose your weapon." +
                    "\n [R P S]: ");
            do {
                playerTwo = in.nextLine();
                if (playerTwo.equalsIgnoreCase("R")
                        || playerTwo.equalsIgnoreCase("P")
                        || playerTwo.equalsIgnoreCase("S"))
                    done = true;
                else
                    System.out.print(playerTwo + " isn't an acceptable play. Try again." +
                            "\nType R, P or S [R P S]: ");
            } while (!done);

            System.out.println("\nIt's " + playerOne + " versus " + playerTwo + "...\n");

            if (playerOne.equalsIgnoreCase("R")) {
                if (playerTwo.equalsIgnoreCase("R")) {
                    System.out.println("The Players tie.");
                    playerTies++;
                }
                else if (playerTwo.equalsIgnoreCase("P")) {
                    System.out.println("Paper covers Rock, Player Two wins!");
                    playerTwoWins++;
                }
                else{
                    System.out.println("Rock smashes Scissors, Player One wins!");
                    playerOneWins++;
                }
            } else if (playerOne.equalsIgnoreCase("P")) {
                if (playerTwo.equalsIgnoreCase("R")) {
                    System.out.println("Paper covers rock, Player One wins!");
                    playerOneWins++;
                }
                else if (playerTwo.equalsIgnoreCase("P")) {
                    System.out.println("The Players tie.");
                    playerTies++;
                }
                else{
                    System.out.println("Scissors cut Paper, Player Two wins!");
                    playerTwoWins++;
                }
            } else { // here u could put if(playerOne.equalsIgnoreCase("S")) but let's live dangerously
                if (playerTwo.equalsIgnoreCase("R")) {
                    System.out.println("Rock smashes Scissors, Player Two wins!");
                    playerTwoWins++;
                }
                else if (playerTwo.equalsIgnoreCase("P")) {
                    System.out.println("Scissors cut Paper, Player One wins!");
                    playerOneWins++;
                }
                else{
                    System.out.println("The Players tie.");
                    playerTies++;
                }
            }
            //now for the post-game.
            done = false;
            System.out.print("Play again? [Y N]: ");
            do{
                playAgain = in.nextLine();
                if(playAgain.equalsIgnoreCase("Y")){
                    System.out.println("OK!\n");

                    System.out.printf("%-15s %2d\n", playerOneIntro, playerOneWins);
                    System.out.printf("%-15s %2d\n", playerTwoIntro, playerTwoWins);
                    System.out.printf("%-15s %3d\n", playerTiesIntro, playerTies);
                    System.out.println();

                    done = true;

                }else if(playAgain.equalsIgnoreCase("N")){
                    System.out.println("\nFINAL STATS:");

                    System.out.printf("%-15s %2d\n", playerOneIntro, playerOneWins);
                    System.out.printf("%-15s %2d\n", playerTwoIntro, playerTwoWins);
                    System.out.printf("%-15s %3d\n", playerTiesIntro, playerTies);
                    System.out.println();

                    if(playerOneWins > playerTwoWins)
                        System.out.println("Player One wins overall!");
                    else if(playerOneWins == playerTwoWins)
                        System.out.println("The Players tie overall!");
                    else System.out.println("Player Two wins overall!");

                    System.out.println("\nThanks for playing!");
                    gameOver = true;
                    done = true;
                }
                else System.out.print(playAgain + " isn't an acceptable choice." +
                        "\nPlease type Y or N [Y N]: ");
            }while (!done);
        }while (!gameOver);
        System.exit(0);
    }
}