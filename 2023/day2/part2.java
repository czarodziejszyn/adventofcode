import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part2{
  public static void main(String[] args){
    try{
      if(args.length == 0){
        return;
      }
      String path = args[0];
      File input = new File(path);
      Scanner reader = new Scanner(input);
      int sum = 0;
      int r, g, b;

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        String[] list = line.split(" ");
        r = 0;
        g = 0;
        b = 0;

        for(int i = 3; i < list.length; i++){
          if(list[i].indexOf("red") >= 0){
            if(Integer.valueOf(list[i-1]) > r){
              r = Integer.valueOf(list[i-1]);
            }
          }
          else if(list[i].indexOf("green") >= 0){
            if(Integer.valueOf(list[i-1]) > g){
              g = Integer.valueOf(list[i-1]);
            }
          }
          else if(list[i].indexOf("blue") >= 0){
            if(Integer.valueOf(list[i-1]) > b){
              b = Integer.valueOf(list[i-1]);
            }
          }
        }
        sum += (r * g * b); 
      }

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}
