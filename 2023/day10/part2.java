import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
      ArrayList<ArrayList<Character>> pipes = new ArrayList<>();
      ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
      int x, y;
      x = y = 0;
      int numLine = -1;
      
      while(reader.hasNextLine()){
        numLine++;
        String line = reader.nextLine();
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> ints = new ArrayList<>();
        for(int i = 0; i < line.length(); i++){
          chars.add(line.charAt(i));
          ints.add(-1);
          if(line.charAt(i) == 'S'){
            x = numLine;
            y = i;
            ints.set(ints.size()-1, 0);
          }
        }
        pipes.add(chars);
        paths.add(ints);
      }
      
      Queue<Node> queue = new LinkedList<>();
      
      // - | J 7 F L
      if(x > 0){
        if(pipes.get(x-1).get(y) == '7' || pipes.get(x-1).get(y) == '|' || pipes.get(x-1).get(y) == 'F'){
          paths.get(x-1).set(y, 1);
          Node node = new Node(x-1, y, 1);
          queue.offer(node);
        }
      }
      if(x < pipes.size()-1){
        if(pipes.get(x+1).get(y) == '|' || pipes.get(x+1).get(y) == 'J' || pipes.get(x+1).get(y) == 'L'){
          paths.get(x+1).set(y, 1);
          Node node = new Node(x+1, y, 3);
          queue.offer(node);
        }
      }
      if(y > 0){
        if(pipes.get(x).get(y-1) == '-' || pipes.get(x).get(y-1) == 'F' || pipes.get(x).get(y-1) == 'L'){
          paths.get(x).set(y-1, 1);
          Node node = new Node(x, y-1, 2);
          queue.offer(node);
        }
      }
      if(y < pipes.get(x).size()-1){
        if(pipes.get(x).get(y+1) == '-' || pipes.get(x).get(y+1) == '7' || pipes.get(x).get(y+1) == 'J'){
          paths.get(x).set(y+1, 1);
          Node node = new Node(x, y+1, 4);
          queue.offer(node);
        }
      }
      int maxPath = 0;
      
      while(!queue.isEmpty()){
        Node node = queue.poll();
        if(node.previous == 1){
          paths.get(node.x).set(node.y, paths.get(node.x+1).get(node.y)+1);
          if(paths.get(node.x).get(node.y) > maxPath){
            maxPath = paths.get(node.x).get(node.y);
          }
        }
        else if(node.previous == 2){
          paths.get(node.x).set(node.y, paths.get(node.x).get(node.y+1)+1);
          if(paths.get(node.x).get(node.y) > maxPath){
            maxPath = paths.get(node.x).get(node.y);
          }
        }
        else if(node.previous == 3){
          paths.get(node.x).set(node.y, paths.get(node.x-1).get(node.y)+1);
          if(paths.get(node.x).get(node.y) > maxPath){
            maxPath = paths.get(node.x).get(node.y);
          }
        }
        else{
          paths.get(node.x).set(node.y, paths.get(node.x).get(node.y-1)+1);
          if(paths.get(node.x).get(node.y) > maxPath){
            maxPath = paths.get(node.x).get(node.y);
          }
        }
        if(node.previous == 1){
          if(pipes.get(node.x).get(node.y) == '|'){
            if(paths.get(node.x-1).get(node.y) == -1){
              Node newNode = new Node(node.x-1, node.y, 1);
              queue.offer(newNode);
            }
          }
          else if(pipes.get(node.x).get(node.y) == 'F'){
            if(paths.get(node.x).get(node.y+1) == -1){
              Node newNode = new Node(node.x, node.y+1, 4);
              queue.offer(newNode);
            }
          }
          else if(pipes.get(node.x).get(node.y) == '7'){
            if(paths.get(node.x).get(node.y-1) == -1){
              Node newNode = new Node(node.x, node.y-1, 2);
              queue.offer(newNode);
            }
          }
        }
        else if(node.previous == 2){
          if(pipes.get(node.x).get(node.y) == '-'){
            if(paths.get(node.x).get(node.y-1) == -1){
              Node newNode = new Node(node.x, node.y-1, 2);
              queue.offer(newNode);
            }
          }
          else if(pipes.get(node.x).get(node.y) == 'L'){
            if(paths.get(node.x-1).get(node.y) == -1){
              Node newNode = new Node(node.x-1, node.y, 1);
              queue.offer(newNode);
            }
          }
          else if(pipes.get(node.x).get(node.y) == 'F'){
            if(paths.get(node.x+1).get(node.y) == -1){
              Node newNode = new Node(node.x+1, node.y, 3);
              queue.offer(newNode);
            }
          }
        }
        else if(node.previous == 3){
          if(pipes.get(node.x).get(node.y) == '|'){
            if(paths.get(node.x+1).get(node.y) == -1){
              Node newNode = new Node(node.x+1, node.y, 3);
              queue.offer(newNode);
            }
          }
          if(pipes.get(node.x).get(node.y) == 'J'){
            if(paths.get(node.x).get(node.y-1) == -1){
              Node newNode = new Node(node.x, node.y-1, 2);
              queue.offer(newNode);
            }
          }
          if(pipes.get(node.x).get(node.y) == 'L'){
            if(paths.get(node.x).get(node.y+1) == -1){
              Node newNode = new Node(node.x, node.y+1, 4);
              queue.offer(newNode);
            }
          }
        }
        else{
          if(pipes.get(node.x).get(node.y) == '-'){
            if(paths.get(node.x).get(node.y+1) == -1){
              Node newNode = new Node(node.x, node.y+1, 4);
              queue.offer(newNode);
            }
          }
          else if(pipes.get(node.x).get(node.y) == 'J'){
            if(paths.get(node.x-1).get(node.y) == -1){
              Node newNode = new Node(node.x-1, node.y, 1);
              queue.offer(newNode);
            }
          }
          else if(pipes.get(node.x).get(node.y) == '7'){
            if(paths.get(node.x+1).get(node.y) == -1){
              Node newNode = new Node(node.x+1, node.y, 3);
              queue.offer(newNode);
            }
          }
        }
      }

      int sum = 0;
      char lastChar = ' ';
      for(int i = 0; i < paths.size(); i++){
        int numCounter = -1;
        int num = 0;
        lastChar = ' ';
        for(int j = 0; j < paths.get(i).size(); j++){
          char actual = pipes.get(i).get(j);
          if(paths.get(i).get(j) != -1 && pipes.get(i).get(j) != '-'){  
            if(lastChar == 'L' && actual == '7'){
              lastChar = actual;
            }
            else if(lastChar == 'F' && actual == 'J'){
              lastChar = actual;
            }
            else{
              lastChar = actual;
              numCounter *= -1;
              num = 0;
            }
          }
          else{
            if(numCounter == 1 && lastChar != 'L' && lastChar != 'F'){
              num++;
              sum++;
            }
          }
          if(paths.get(i).get(j) != -1){
            System.out.printf("x");
          }
          else{
            System.out.printf(".");
          }
        }
        System.out.println("");
        sum -= num;
      }
      
      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}

class Node{
  public int x;
  public int y;
  public int previous;
  
  public Node(int x, int y, int previous){
    this.x = x;
    this.y = y;
    this.previous = previous;
  }
}
