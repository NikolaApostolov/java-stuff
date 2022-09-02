package cryptogram.game;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class UndoLetterTests {
	
	private Player currentPlayer = new Player();
	private Game game;
	private Game gameNum;
	
	public UndoLetterTests() {}
	
	@Before
	public void setUp() {
		game = new Game(currentPlayer, "letter");
		gameNum = new Game(currentPlayer, "number");
	}

	@Test
	public void testUndoForLetter() { // tests the .undoLetter method for a letter cryptogram
		
			setUp();
		
		// take the vary first value from the cryptogram and create an input
			
			char cryptoLetter = game.getCryptogram().getJumbledPhrase().charAt(0);
			
			String cryptoLetterString = Character.toString(cryptoLetter);
			String input = new StringBuilder(cryptoLetterString).append(" ").append("z").toString();
		
		// test undoLetter after a single input
			game.enterLetter(input);
			game.undoLetter(cryptoLetterString);
			assertEquals(true, game.getPlayerGameMapping().isEmpty());
		
		// test undoLetter for an empty cryptogram
			game.undoLetter(cryptoLetterString);
			assertEquals(true, game.getPlayerGameMapping().isEmpty());
		
		// continuously input into the cruptogram
			char newLetter;
			char[] inputLetterArray = {'a', 'o', 'u', 't', 'e', 'w', 'b', 'h', 'i', 'n', 'p', 'c', 'y', 'l'};
			ArrayList<String> arrKey = new ArrayList<String>();
			arrKey.add(" ");
		
			for (int i = 1; i < inputLetterArray.length; i++) {
				newLetter = game.getCryptogram().getJumbledPhrase().charAt(i);
				String inputKey = Character.toString(newLetter);
				if (arrKey.contains(inputKey)) {
					i++;
				} else {
				
					arrKey.add(inputKey);
					String inputLetter = Character.toString(inputLetterArray[i]);
					input = new StringBuilder(inputKey).append(" ").append(inputLetter).toString();
					game.enterLetter(input);
			
					}
			}
		
		// tests the current size of playerGameMapping after 3 undos
			int inputSize = game.getPlayerGameMapping().size();
		
			game.undoLetter(arrKey.get(1));
			game.undoLetter(arrKey.get(2));
			game.undoLetter(arrKey.get(3));
		
			assertEquals(game.getPlayerGameMapping().size(), inputSize - 3); // test size
		
		// test undoLetter for an incorrect input
			game.undoLetter("bob");
			assertEquals(game.getPlayerGameMapping().size(), inputSize - 3); // size stays the same
		
	}
	
	@Test
	public void testUndoForNumber() {
		
			setUp();
		
		// take the vary first value from the cryptogram and create an input
			
			char c1;
			char c2;
			String cryptoNumberString;
		
			if (gameNum.getCryptogram().getJumbledPhrase().charAt(1) == ' ') {
				c1 = gameNum.getCryptogram().getJumbledPhrase().charAt(0);
				cryptoNumberString = Character.toString(c1);
			}
			else {
				c1 = gameNum.getCryptogram().getJumbledPhrase().charAt(0);
				c2 = gameNum.getCryptogram().getJumbledPhrase().charAt(1);
				cryptoNumberString = new StringBuilder().append(c1).append(c2).toString();
			}
			
			
			String input = new StringBuilder().append(cryptoNumberString).append(" ").append("z").toString();
			
		// test undoLetter after a single input
			gameNum.enterLetter(input);
			gameNum.undoLetter(cryptoNumberString);
			assertEquals(true, game.getPlayerGameMapping().isEmpty());
					
		// test undoLetter for an empty cryptogram
			gameNum.undoLetter(cryptoNumberString);
			assertEquals(true, gameNum.getPlayerGameMapping().isEmpty());
			
		// test undoLetter for an incorrect input
			if (gameNum.getCryptogram().getJumbledPhrase().charAt(1) == ' ') {
				c1 = gameNum.getCryptogram().getJumbledPhrase().charAt(0);
				cryptoNumberString = Character.toString(c1);
			}
			else {
				c1 = gameNum.getCryptogram().getJumbledPhrase().charAt(0);
				c2 = gameNum.getCryptogram().getJumbledPhrase().charAt(1);
				cryptoNumberString = new StringBuilder().append(c1).append(c2).toString();
			}
			
			
			input = new StringBuilder().append(cryptoNumberString).append(" ").append("b").toString();
			gameNum.enterLetter(input);
			assertEquals(gameNum.getPlayerGameMapping().size(), 1); // test size 
			
			gameNum.undoLetter("27");
			assertEquals(gameNum.getPlayerGameMapping().size(), 1); // size stays the same
	}

}
