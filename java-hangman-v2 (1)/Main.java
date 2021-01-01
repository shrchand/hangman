import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    int strikes = 0;
    Scanner input = new Scanner(System.in);
    Word gameWord = new Word();
    System.out.println("\nWelcome to Hangman! Would you like to play with easy words or hard words?\n\nType 'e' for easy or 'h' for hard.");
    String mode = input.nextLine();
    if (mode.toLowerCase().equals("e") == true) {
      gameWord.getEasyWord();
      strikes = 6;
    } else if (mode.toLowerCase().equals("h") == true) {
      gameWord.getHardWord();
      strikes = 10;
    } else {
      System.err.println("\nLooks like you didn't indicate how difficult you want your word to be! I'll pick a word from the easy list for now.\n");
      gameWord.getEasyWord();
      strikes = 6;
      }
    String randWord = gameWord.hangmanWord;
    int tries = 0;
    System.out.printf("\nReady to begin?\nYou have %d incorrect guess strikes.", strikes);
    String[] letterArr = randWord.split("");
    ArrayList<String> leftToGuess = new ArrayList<String>(Arrays.asList(letterArr));
    List<String> filled = new ArrayList<String>(leftToGuess);
    ArrayList<String> usedLetters = new ArrayList<String>();
    ArrayList<String> blankLetters = new ArrayList<String>();
    for (int c = 0; c < filled.size(); c++) {
      blankLetters.add("_");
    }
    while (leftToGuess.equals(blankLetters) == false) {
      System.out.println("\n");
      for (int c = 0; c < filled.size(); c++) {
        if (leftToGuess.get(c) == "_") {
          System.out.print(filled.get(c) + " ");
        } else {
          System.out.print("_ ");
        }
      }
      System.out.println("\nGuess a letter or the whole word!");
      String guessedLetter = input.nextLine().toUpperCase();
      if (guessedLetter.length() < 1) {
        System.err.println("You didn't enter anything. Try again.");
      } else if (guessedLetter.length() > 1) {
        System.out.println("\nAre you trying to guess the whole word? (y/n)");
        String yesNo = input.nextLine().toLowerCase();
        if (yesNo.equals("y") == true) {
          if (guessedLetter.equals(randWord) == true) {
            break;
          } 
          else {
            tries += 1;
            System.out.printf("\nSorry, that's incorrect. %d tries remaining.", (strikes - tries));
            if (tries >= strikes) {
              break;
            }
          }
        } 
        else {
          System.out.println("You did not guess a letter or a word. Try again.");
        }
      } else if (alpha.contains(guessedLetter.toLowerCase()) == false) {
        System.out.println("Invalid entry. Try again.");
      } else if (usedLetters.contains(guessedLetter) == true) {
        System.out.println("\nYou already guessed this letter!");
      } else if (leftToGuess.contains(guessedLetter) == true) {
        System.out.println("\nCorrect!");
        usedLetters.add(guessedLetter);
        Collections.replaceAll(leftToGuess, guessedLetter, "_");
      } else {
        usedLetters.add(guessedLetter);
        tries += 1;
        System.out.printf("\nIncorrect! You have %d incorrect guesses left.\n", (strikes - tries));
        if (tries >= strikes) {
          break;
        }
      }
    }
    input.close();
    if (tries >= strikes) {
      System.out.printf("You used all of your tries! The word was '%s'. Game over!", randWord.toLowerCase());
    } else {
      System.out.println("\n" + randWord);
      System.out.println("Congratulations! You won!");
    }
  }
}