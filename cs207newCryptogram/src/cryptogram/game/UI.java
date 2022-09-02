package cryptogram.game;

import java.util.Scanner;

public class UI {
  private Scanner input = new Scanner(System.in);
  private Player currentPlayer = new Player();
  private Game game;

  public UI() {
  }

  public void run() {
    String inptStr;

    while (true) {
      menu();

      inptStr = input.nextLine();
      try {
        parseInput(Integer.parseInt(inptStr));
      } catch (NumberFormatException e) {
        if (inptStr.equals("q")) {
          System.exit(0);
        }
        System.out.println("Please input a number or q.");
      }
    }
  }

  private void menu() {
    System.out.println("Cryptograms Game!");
    System.out.println("1. Generate Letter Cryptogram");
    System.out.println("2. Generate Number Cryptogram");
    System.out.println("3. Display Player Details");
    System.out.println("q: Quit Game");
  }

  private void parseInput(int inpt) {
    switch (inpt) {
      case 1:
        game = new Game(currentPlayer, "letter");
        game();
        break;
      case 2:
        game = new Game(currentPlayer, "number");
        game();
        break;
      case 3:
        playerDetails();
        break;
      default:
        System.out.println("Please insert a valid option.");
    }
  }

  private void game() {
    while (true) {
      System.out.println("Cryptogram: ");
      System.out.println('\t' + game.getCryptogram().getUserPhrase(game.getPlayerGameMapping()));
      System.out.println('\t' + game.getCryptogram().getJumbledPhrase());
      System.out.println("1. Set Letter");
      System.out.println("2. Undo Letter");
      System.out.println("q. Quit Cryptogram");

      String inptStr = input.nextLine();
      String userInput;

      try {
        // Set letter etc...
        switch (Integer.parseInt(inptStr)) {
          case 1:
            System.out.println("Example Input - x j");
            System.out.println("Input the value you would like to map to and the value you want mapped with a space placed in between:");
            userInput = input.nextLine();
            game.enterLetter(userInput);
            break;
          case 2:
        	  if (game.getPlayerGameMapping().isEmpty()) {
        		  System.out.println("There are no inputs to be undone. Please enter a letter first.");
        		  break;
        	  } else {
            System.out.println("Which cryptogram value should be undone? ");
            userInput = input.nextLine();
            game.undoLetter(userInput);
            break;
        	  }
          default:
            System.out.println("Please insert a valid option.");
        }
      } catch (NumberFormatException e) {
        if (inptStr.equals("q")) {
          break;
        }
        System.out.println("Please input a number or q.");
      }
    }
  }

  private void playerDetails() {
    System.out.println('\n' + currentPlayer.toString());
    System.out.println("************************\n");
  }
}
