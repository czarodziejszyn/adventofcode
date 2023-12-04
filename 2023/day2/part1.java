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
      int game = 1;
      int r, g, b;
      r = 12;
      g = 13;
      b = 14;

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        String[] list = line.split(" ");
        int good = 1;

        for(int i = 3; i < list.length; i++){
          if(list[i].indexOf("red") >= 0){
            if(Integer.valueOf(list[i-1]) > r){
              good = 0;
              break;
            }
          }
          else if(list[i].indexOf("green") >= 0){
            if(Integer.valueOf(list[i-1]) > g){
              good = 0;
              break;
            }
          }
          else if(list[i].indexOf("blue") >= 0){
            if(Integer.valueOf(list[i-1]) > b){
              good = 0;
              break;
            }
          }
        }

        if(good == 1){
          sum += game; 
        }

        game++;
      }

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}
