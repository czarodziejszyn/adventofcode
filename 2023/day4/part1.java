import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

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

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        line = line.trim().replaceAll(" +", " ");

        String[] numbers = line.split(" ");

        int[] winning = new int[10];
        int[] myNumbers = new int[25];

        for(int i = 2; i < 12; i++){
          winning[i-2] = Integer.valueOf(numbers[i]);
        }
        Arrays.sort(winning);

        for(int i = 13; i < 38; i++){
          myNumbers[i-13] = Integer.valueOf(numbers[i]);
        }
        Arrays.sort(myNumbers);

        int winIndex = 0;
        int myIndex = 0;
        int duplicates = 0;

        while(winIndex < 10 && myIndex < 25){
          if(winning[winIndex] == myNumbers[myIndex]){
            duplicates++;
            winIndex++;
            myIndex++;
          }
          else if(winning[winIndex] > myNumbers[myIndex]){
            myIndex++;
          }
          else{
            winIndex++;
          }
        }

        sum += (int)Math.pow(2,(duplicates-1));
      }

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}
