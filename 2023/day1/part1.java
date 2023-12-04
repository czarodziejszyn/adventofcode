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
      int first, last;
      first = 0;
      last = 0;

      while(reader.hasNextLine()){
        String line = reader.nextLine();

        for(int i = 0; i < line.length(); i++){
          if(Character.isDigit(line.charAt(i))){
            first = Character.getNumericValue(line.charAt(i));
            break;
          }
        }

        for(int i = line.length()-1; i >= 0 ;i--){
          if(Character.isDigit(line.charAt(i))){
            last = Character.getNumericValue(line.charAt(i));
            break;
          }
        }

        sum += 10*first + last;
      }

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}
