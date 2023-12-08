import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class part2{
  public static void main(String[] args){
    try{
      if(args.length == 0){
        return;
      }
      String path = args[0];
      File input = new File(path);
      Scanner reader = new Scanner(input);
      Map<String, Node> pointsMap = new HashMap<>();
      Queue<String> queue = new LinkedList<>();
      Long sum = 0L;
      int queueSize = 0;
      
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

        if(content.charAt(content.length()-1) == 'A'){
          queue.offer(content);
          queueSize++;
        }
      }
      
      Long[] circles = new Long[queueSize];
      for(int i = 0; i < queueSize; i++){
        circles[i] = 0L;
      }
      String position;
      int instructionIndex = -1;
      int numOfZ = 0;
      while(numOfZ != queueSize){
        sum++;
        instructionIndex++;
        if(instructionIndex >= instructions.length()){
          instructionIndex = 0;
        }
        for(int i = 0; i < queueSize; i++){
          String removed = queue.poll();
          if(instructions.charAt(instructionIndex) == 'R'){
            position = pointsMap.get(removed).getRight();
          }
          else{
            position = pointsMap.get(removed).getLeft();
          }
          if(position.charAt(position.length()-1) == 'Z'){
            numOfZ++;
            if(circles[i] == 0){
              circles[i] = sum;
            }
          }
          queue.offer(position);
        }
      }
      Long a = circles[0];
      for(int i = 1; i < queueSize; i++){
        Long b = circles[i];
        a = greatestCommonDivider(a, b);
      }
      sum = lowestCommonMultiple(a, circles);
      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
  static Long lowestCommonMultiple(Long a, Long[] b){
    Long c = 1L;
    for(int i = 0; i < b.length; i++){
      c *= b[i];
      c /= a;
    }
    c *= a;
    return c;
  }

  static Long greatestCommonDivider(Long a, Long b){
    while(a > 0){
      a = a%b;
      b -= a;
    }
    return b;
  }
}

