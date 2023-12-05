import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class part2{
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
      ArrayList<Long> seeds = new ArrayList<Long>();
      ArrayList<Integer> changes = new ArrayList<Integer>();
      
      for(int i = 1; i < firstLine.length-1; i+=2){
        seeds.add(Long.valueOf(firstLine[i]));
        seeds.add(Long.valueOf(firstLine[i]) + Long.valueOf(firstLine[i+1]));
        changes.add(0);
      }

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        String[] content = line.split(" ");

        if(content.length > 2){
          Long act = Long.valueOf(content[0]);
          Long prev = Long.valueOf(content[1]);
          Long range = Long.valueOf(content[2]);
          range -= 1;
          int option;

          for(int i = 0; i < seeds.size(); i+=2){
            option = 0;
            if(seeds.get(i) <= prev && seeds.get(i+1) >= prev && changes.get(i/2) == 0){
              if(prev > seeds.get(i)){
                seeds.add(seeds.get(i));
                seeds.add(prev-1);
                changes.add(0);
              }
              if(seeds.get(i+1) < prev + range){
                option = 1;
              }
              if(prev + range < seeds.get(i+1)){
                seeds.add(prev + range);
                seeds.add(seeds.get(i+1));
                changes.add(0);
                option = 2;
              }
              if(option == 1){
                seeds.set(i, act);
                seeds.set(i+1, act+seeds.get(i+1)-prev);
                changes.set(i/2, 1);
              }
              else if(option == 2){
                seeds.set(i, act);
                seeds.set(i+1, act+range);
                changes.set(i/2, 1);
              }
            }
            else if(seeds.get(i) > prev && seeds.get(i) <= prev + range && changes.get(i/2) == 0){
              if(seeds.get(i+1) <= prev + range){
                option = 1;
              }
              if(seeds.get(i+1) > prev + range){
                seeds.add(prev+range+1);
                seeds.add(seeds.get(i+1));
                changes.add(0);
                option = 2;
              }
              if(option == 1){
                seeds.set(i+1, act+seeds.get(i+1)-prev);
                seeds.set(i, act+seeds.get(i)-prev);
                changes.set(i/2, 1);
              }
              else if(option == 2){
                Long extraRange = seeds.get(seeds.size()-2)-seeds.get(i)-1;
                seeds.set(i, act+seeds.get(i)-prev);
                seeds.set(i+1, seeds.get(i)+extraRange);
                changes.set(i/2, 1);
              }
            }
          }
        }
        else{
          for(int i = 0; i < changes.size(); i++){
            changes.set(i, 0);
          }
        }
      }

      Collections.sort(seeds);

      System.out.println(seeds.get(0));
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}
