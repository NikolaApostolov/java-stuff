package cryptogram.game;
// Fake leaderboard

import java.util.ArrayList;
import java.util.HashMap;

public class Players {
  ArrayList<Player> allPlayers = new ArrayList<>();
  String playersFile;

  public Player addPlayer(Player p) {
    return null;
  }

  public void savePlayers() {

  }

  public int findPlayerPos(Player p) {
    return 0;
  }

  public HashMap<String, Double> getAllPlayerAccuracies() {   // Hashmap of username to accuracy
    return new HashMap<>();
  }

  public HashMap<String, Integer> getAllPlayerCryptogramsPlayed() {   // Hashmap of username to cryptograms played
    return new HashMap<>();
  }

  public HashMap<String, Integer> getAllPlayerCryptogramsWon() {   // Hashmap of username to cryptograms won
    return new HashMap<>();
  }
}
