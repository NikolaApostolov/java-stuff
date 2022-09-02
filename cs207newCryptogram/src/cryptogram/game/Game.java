package cryptogram.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Game {
  private Player currentPlayer = new Player();
  private Cryptogram cryptogram;
  private HashMap<String, Character> playerGameMapping;
  Scanner input = new Scanner(System.in);

  public HashMap<String, Character> getPlayerGameMapping() {
    return playerGameMapping;
  }

  public Game(Player p) { // Default cryptogram type 'letter'
    currentPlayer = p;
    cryptogram = new LetterCryptogram();
    playerGameMapping = new HashMap<>();
  }

  public Game(Player p, String cryptType) {
    currentPlayer = p;
    if (cryptType.equals("letter")) {
      cryptogram = new LetterCryptogram();
    } else {
      cryptogram = new NumberCryptogram();
    }
    generateCryptogram();
    playerGameMapping = new HashMap<>();
  }

  public void getHint() {

  }

  public void loadPlayed() {

  }

  public void playGame() {

  }

  public void generateCryptogram() {
    try {
      Scanner sc = new Scanner(new BufferedReader(new FileReader("phrases.txt")));
      ArrayList<String> phrases = new ArrayList<>();
      Random rng = new Random();

      while (sc.hasNext()) {
        phrases.add(sc.nextLine());
      }
      int num = rng.nextInt(15);

      String selected = phrases.get(num);

      cryptogram.setPhrase(selected);
      cryptogram.jumble();
    } catch (FileNotFoundException e) {
      System.out.println("404. Phrases not found.");
    }
  }

  // This method takes in a user's input and maps it to the correct cryptogram value they have entered
  public void enterLetter(String userInput) {
    String[] inputCheck = userInput.split(" ");
    String cryptogramValue = inputCheck[0];
    char userLetter;

    try {
      userLetter = inputCheck[1].charAt(0);
      int intCheck;
      boolean isInt = false;


      try {
        intCheck = Integer.parseInt(inputCheck[0]);
        isInt = true;
      } catch (NumberFormatException e) {
        intCheck = 1;
      }

      if (intCheck >= 26 || intCheck <= -1 || inputCheck[1].length() > 1)
        throw new IndexOutOfBoundsException();

      if (!isInt && inputCheck[0].length() > 1)
        throw new IndexOutOfBoundsException();

    } catch (IndexOutOfBoundsException e) {
      System.out.println("Input was not of a correct format, please try again.");
      return;
    }

    if (!Character.isLetter(userLetter)) {
      System.out.println("The input value needs to be a plain letter.");
      return;
    }

    userLetter = Character.toLowerCase(userLetter);

    if (!cryptogram.getJumbledPhrase().contains(cryptogramValue)) {
      System.out.println("This cryptogram value does not exist");
      return;
    } else if (playerGameMapping.containsValue(userLetter)) {
      System.out.println("This letter has already been mapped please try again");
      return;
    } else if (playerGameMapping.containsKey(cryptogramValue)) {
      System.out.print("This has already been mapped are you sure you want to remap it (Y/n): ");
      if (input.nextLine().equals("y")) {
        playerGameMapping.put(cryptogramValue, userLetter);
      } else
        return;
    } else
      playerGameMapping.put(cryptogramValue, userLetter);
  }


  // The method takes the last entered letter position and undoes it
  public void undoLetter(String cryptInput) {
	
	if (!cryptogram.getJumbledPhrase().contains(cryptInput))  {
		System.out.println("This cryptogram value isn't part of the cryptogram.");
	}else if (!playerGameMapping.containsKey(cryptInput)) {
		System.out.println("This cryptogram value isn't mapped to a letter. Please try another one.");
	}
	  
    playerGameMapping.remove(cryptInput);
  }

  public void viewFrequencies() {

  }

  public void saveGame() {

  }

  public void loadGame() {

  }

  public void showSolution() {

  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(Player currentPlayer) {
    this.currentPlayer = currentPlayer;
  }

  public Cryptogram getCryptogram() {
    return cryptogram;
  }

  public void setCryptogram(Cryptogram cryptogram) {
    this.cryptogram = cryptogram;
  }
  
}
