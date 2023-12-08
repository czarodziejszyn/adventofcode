import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part1{
  public static void main(String[] args){
    try{
      if(args.length == 0){
        return;
      }
      String path = args[0];
      File input = new File(path);
      Scanner reader = new Scanner(input);
      int sum = 0;

      String map = reader.nextLine();
      
      for(int i = 0; i < map.length(); i++){
        if(map.charAt(i) == '('){
          sum++;
        }
        else{
          sum--;
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
