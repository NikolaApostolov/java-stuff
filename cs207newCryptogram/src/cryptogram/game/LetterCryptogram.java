package cryptogram.game;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class LetterCryptogram extends Cryptogram<Character> {
  public LetterCryptogram() {
    super();
    cryptogramAlphabet = new HashMap<>();
  }

  public LetterCryptogram(String file) {

  }

  @Override
  public void jumble() {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    Stack<Character> randomAlphabet = new Stack<>();

    for (Character c : alphabet) {
      randomAlphabet.push(c);
    }
    super.jumble(randomAlphabet);
  }

  @Override
  public String getUserPhrase(HashMap<String, Character> playerGameMapping) {

    StringBuilder jumble = new StringBuilder();

    for (char c : getJumbledPhrase().toCharArray()) {
      if (Character.isLetter(c) && playerGameMapping.containsKey(c + "")) {
        jumble.append(playerGameMapping.get(c + ""));
      } else {
        jumble.append(' ');
      }
    }
    return jumble.toString();
  }


  public HashMap<Character, Character> getCryptogramAlphabet() {
    return cryptogramAlphabet;
  }

  public String getJumbledPhrase() {
    StringBuilder jumble = new StringBuilder();

    for (char c : phrase.toCharArray()) {
      if (Character.isLetter(c)) {
        jumble.append(cryptogramAlphabet.get(c));
      } else {
        jumble.append(' ');
      }
    }
    return jumble.toString();
  }

  public char getPlainLetter(char cryptoLetter) {
    return 'x';
  }
}
