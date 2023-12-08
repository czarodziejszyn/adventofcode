import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class part1{
  public static void main(String[] args){
    try{
      if(args.length == 0){
        return;
      }
      String path = args[0];
      File input = new File(path);
      Scanner reader = new Scanner(input);
      Map<String, Node> scores = new HashMap<>();
      int sum = 0;
      
      String instructions = reader.nextLine();

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        String[] words = line.split(" ");
        String content = words[0];
        int bet = Integer.valueOf(words[1]);

      }

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}

public class Node{
  private String content;
  private Node leftNode;
  private Node rightNode;
}

