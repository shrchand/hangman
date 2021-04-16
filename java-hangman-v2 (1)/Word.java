import java.util.*;
import java.io.*;
import java.lang.*;
import java.nio.file.*;
import java.nio.charset.Charset;
public class Word {
  String hangmanWord;
  void getEasyWord() throws IOException {
    System.out.println("Getting your word...");
    List<String> lines = new ArrayList<>();
    lines = Files.readAllLines(Paths.get("words.txt"), Charset.defaultCharset());
    Random word = new Random();
    int randNum = word.nextInt(lines.size());
    hangmanWord = lines.get(randNum);
  }
  void getHardWord() throws IOException {
    System.out.println("Getting your word...");
    List<String> lines = new ArrayList<>();
    lines = Files.readAllLines(Paths.get("sowpods.txt"), Charset.defaultCharset());
    Random word = new Random();
    int randNum = word.nextInt(lines.size());
    hangmanWord = lines.get(randNum);
  }
}
