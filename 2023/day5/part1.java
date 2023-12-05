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

      String start = reader.nextLine();
      String[] firstLine = start.split(" ");
      Long[] seeds = new Long[firstLine.length-1];
      int[] changes = new int[firstLine.length-1];
      for(int i = 0; i < changes.length; i++){
        changes[i] = 0;
      }

      for(int i = 1; i  < firstLine.length; i++){
        seeds[i-1] = Long.valueOf(firstLine[i]);
      }

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        String[] content = line.split(" ");
        if(content.length > 2){
          Long act = Long.valueOf(content[0]);
          Long prev = Long.valueOf(content[1]);
          Long range = Long.valueOf(content[2]);

          for(int i = 0; i < seeds.length; i++){
            if(seeds[i] >= prev && seeds[i] < prev+range && changes[i] == 0){
              seeds[i] = act+(seeds[i] - prev);
              changes[i] = 1;
            }
          }
        }
        else{
          for(int i = 0; i < changes.length; i++){
            changes[i]=0;
          }
        }
      }

      Arrays.sort(seeds);

      System.out.println(seeds[0]);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}
