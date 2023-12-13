import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

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
      int num = 0;

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        String[] words = line.split(" ");
        String[] nums = words[1].split(",");
        int[] number = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
          number[i] = Integer.valueOf(nums[i]);
        }
        ArrayList<Integer> lengths = new ArrayList<>();
        for(int i = 0; i < words[0].length(); i++){
          while(i < words[0].length && words[i] == '#')

        }
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}
