package cryptogram.game;

public class Player {
  private String username;
  private double accuracy;
  private int correctGuesses;
  private int totalGuesses;
  private int cryptogramsPlayed;
  private int cryptogramsWon;

  public Player() {
    this.username = "example02";
    this.correctGuesses = 3000;
    this.totalGuesses = 12334;
    updateAccuracy();
    this.cryptogramsPlayed = 1;
    this.cryptogramsWon = 0;
  }

  public void updateAccuracy() {
    this.accuracy = (double) correctGuesses / totalGuesses;
  }

  public void incrementCorrectGuesses() {
    correctGuesses++;
  }

  public void incrementTotalGuesses() {
    totalGuesses++;
  }

  public void incrementCryptogramsPlayed() {
    cryptogramsPlayed++;
  }

  public void incrementCryptogramsWon() {
    cryptogramsWon++;
  }

  public double getAccuracy() {
    return accuracy;
  }

  public int getCryptogramsPlayed() {
    return cryptogramsPlayed;
  }

  public int getCryptogramsWon() {
    return cryptogramsWon;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getCorrectGuesses() {
    return correctGuesses;
  }

  public int getTotalGuesses() {
    return totalGuesses;
  }

  @Override
  public String toString() {
    return "*** Current Player ***" +
        "\n\tUsername: " + username +
        "\n\taccuracy: " + String.format("%.2f", accuracy * 100) + "%" +
        "\n\tcorrectGuesses: " + correctGuesses +
        "\n\ttotalGuesses: " + totalGuesses +
        "\n\tcryptogramsPlayed: " + cryptogramsPlayed +
        "\n\tcryptogramsWon: " + cryptogramsWon;
  }
}
