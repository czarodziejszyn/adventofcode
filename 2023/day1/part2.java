import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part2 {
  public static void main(String[] args){
    try{
      if(args.length == 0){
        return;
      }
      String path = args[0];
      File input = new File(path);
      Scanner reader = new Scanner(input);
      int sum = 0;
      int first = 0;
      int last = 0;
      String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

      while(reader.hasNextLine()){
        String line = reader.nextLine();

        for(int i = 0; i < line.length(); i++){
          if(Character.isDigit(line.charAt(i))){
            first = Character.getNumericValue(line.charAt(i));
            int index = line.length();
            for(int j = 0; j < 9; j++){
              if(line.indexOf(numbers[j]) >= 0 && line.indexOf(numbers[j]) < i && line.indexOf(numbers[j]) < index){
                index = line.indexOf(numbers[j]);
                first = j+1;
              }
            }
            break;
          }
        }

        for(int i = line.length()-1; i >= 0 ;i--){
          if(Character.isDigit(line.charAt(i))){
            last = Character.getNumericValue(line.charAt(i));
            int index = 0;
            for(int j = 0; j < 9; j++){
              if(line.lastIndexOf(numbers[j]) >= 0 && line.lastIndexOf(numbers[j]) > i && line.lastIndexOf(numbers[j]) > index){
                index = line.lastIndexOf(numbers[j]);
                last = j+1;
              }
            }
            break;
          }
        }

        sum += 10*first + last;

        //System.out.println(line);
        //System.out.println(10*first+last);
      }

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}
