package cryptogram.game;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class NumberCryptogram extends Cryptogram<Integer> {
  public NumberCryptogram() {
    super();
    cryptogramAlphabet = new HashMap<>();
  }

  public NumberCryptogram(String file) {

  }

  @Override
  public void jumble() {
    Stack<Integer> randomInts = new Stack<>();

    for (int i = 0; i < 26; ++i) {
      randomInts.push(i);
    }

    super.jumble(randomInts);
  }

  public HashMap<Character, Integer> getCryptogramAlphabet() {
    return cryptogramAlphabet;
  }

  public char getPlainLetter(int cryptoLetter) {
    return 'x';
  }

  public String getJumbledPhrase() {
    StringBuilder jumble = new StringBuilder();

    for (char c : phrase.toCharArray()) {
      if (Character.isLetter(c)) {
        jumble.append(cryptogramAlphabet.get(c).toString() + ' ');
      } else {
        jumble.append("  ");
      }
    }
    return jumble.toString();
  }

  public String getUserPhrase(HashMap<String, Character> playerGameMapping) {
    StringBuilder jumble = new StringBuilder();
    for (String c : getJumbledPhrase().split(" ")) {
      if (playerGameMapping.containsKey(c + "")) {
        jumble.append(playerGameMapping.get(c));
      } else {
        jumble.append(" ");
      }
      for (int i = 0; i < c.length(); i++) {
        jumble.append(" ");
      }
    }
    return jumble.toString();
  }

}
