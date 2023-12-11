import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
      ArrayList<ArrayList<Character>> galaxies = new ArrayList<>();
      ArrayList<Node> points = new ArrayList<>();
      int hashCounter = 0;
      int x = -1;
      int sum = 0;

      while(reader.hasNextLine()){
      	x++;
        String line = reader.nextLine();
      	ArrayList<Character> charLine = new ArrayList<>();
	      for(int i = 0; i < line.length(); i++){
	        if(line.charAt(i) == '#'){
	          Node node = new Node(x, i);
            points.add(node);
	        }	    
	        charLine.add(line.charAt(i));
	      }
	      galaxies.add(charLine);
      }

      for(int i = galaxies.size()-1; i > 0; i--){
	      hashCounter = 0;
	      for(int j = 0; j  < galaxies.get(i).size(); j++){
	        if(galaxies.get(i).get(j) == '#'){
	          hashCounter++;
	          break;
	        }
        }
	      if(hashCounter == 0){
    	     for(int j = 0; j < points.size(); j++){
            if(points.get(j).x > i){
              Node node = points.get(j);
              node.x++;
            }
          } 
	      }
	    }

      for(int i = galaxies.get(0).size()-1; i >= 0; i--){
        hashCounter = 0;
        for(int j = 0; j < galaxies.size(); j++){
          if(galaxies.get(j).get(i) == '#'){
            hashCounter++;
          }
        }
        if(hashCounter == 0){
          for(int j = 0; j < points.size(); j++){
            if(points.get(j).y > i){
              Node node = points.get(j);
              node.y++;
            }
          }
        }
      }

      for(int i = 0; i < points.size(); i++){
        for(int j = i; j < points.size(); j++){
          sum += Math.abs(points.get(i).x-points.get(j).x);
          sum += Math.abs(points.get(i).y-points.get(j).y);
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
class Node{
  public int x;
  public int y;
  public Node(int x, int y){
    this.x = x;
    this.y = y;
  }
}
