package cryptogram.game;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public abstract class Cryptogram<T> {
  protected String phrase;
  protected HashMap<Character, Integer> frequencies;
  protected HashMap<Character, T> cryptogramAlphabet;

  public Cryptogram() {
    frequencies = new HashMap<>();
  }

  public void jumble(Stack<T> randomAlphabet) {
    Collections.shuffle(randomAlphabet);

    for (Character c : phrase.toCharArray()) {
      if (!Character.isLetter(c))
        continue;

      if (!cryptogramAlphabet.containsKey(c)) {
        T value = randomAlphabet.pop();
        cryptogramAlphabet.put(c, value);
        frequencies.put(c, 1);
      } else {
        Integer f = frequencies.get(c);
        frequencies.replace(c, f + 1);
      }
    }
  }

  public void setPhrase(String phrase) {
    this.phrase = phrase.toLowerCase();
    this.jumble();
  }

  public HashMap<Character, Integer> getFrequencies() {
    return frequencies;
  }

  public String getPhrase() {
    return phrase;
  }


  public abstract String getJumbledPhrase();

  public abstract void jumble();

  public abstract String getUserPhrase(HashMap<String, Character> playerGameMapping);
}
