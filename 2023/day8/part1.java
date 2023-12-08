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
      Map<String, Node> pointsMap = new HashMap<>();
      int sum = 0;
      
      String instructions = reader.nextLine();
      String empty = reader.nextLine();

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        line = line.replaceAll(",", "");
        line = line.replaceAll("\\(", "");
        line = line.replaceAll("\\)", "");
        line = line.replaceAll("=", "");
        line = line.replaceAll(" +", " ");
        String[] words = line.split(" ");
        String content = words[0];
        String leftNode = words[1];
        String rightNode = words[2];

        Node node = new Node(content, leftNode, rightNode);
        pointsMap.put(content, node);
      }

      String position = "AAA";
      int instructionIndex = -1;
      while(!position.equals("ZZZ")){
        sum++;
        instructionIndex++;
        if(instructionIndex >= instructions.length()){
          instructionIndex = 0;
        }
        if(instructions.charAt(instructionIndex) == 'R'){
          position = pointsMap.get(position).getRight();
        }
        else{
          position = pointsMap.get(position).getLeft();
        }
      }

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}

