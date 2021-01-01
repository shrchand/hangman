import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
public class Word {
  String hangmanWord;
  void getEasyWord(){
    System.out.println("Getting your word...");
    List<String> lines = Collections.emptyList();
    try {
      lines = Files.readAllLines(Paths.get("words.txt"), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    Random word = new Random();
    int randNum = word.nextInt(lines.size());
    hangmanWord = lines.get(randNum);
  }
  void getHardWord(){
    System.out.println("Getting your word...");
    List<String> lines = Collections.emptyList();
    try {
      lines = Files.readAllLines(Paths.get("sowpods.txt"), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    Random word = new Random();
    int randNum = word.nextInt(lines.size());
    hangmanWord = lines.get(randNum);
  }
}