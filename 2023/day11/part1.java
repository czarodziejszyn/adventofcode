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
      int hashCounter = 0;
      int x = -1;

      while(reader.hasNextLine()){
	x++;
        String line = reader.nextLine();
	ArrayList<Character> charLine = new ArrayList<>();
	for(int i = 0; i < line.length(); i++){
	  if(line.charAt(i) == '#'){
	    Node node = new Node(x, i);
	  }	    
	  galaxies.add(line.charAt(i));
	}
	galaxies.add(charLine);
      }

      for(int i = 0; i < galaxies.size(); i++){
	hashCounter = 0;
	for(int j = 0; j  < galaxies.get(i).size(); j++){
	  if(galaxies.get(i).get(j) == '#'){
	    hashCounter++;
	    break;
	  }
	}
	if(hashCounter > 0){
	  
	}
      }

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
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
}
