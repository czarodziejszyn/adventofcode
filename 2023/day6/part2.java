import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class part2{
  public static void main(String[] args){
    try{
      if(args.length == 0){
        return;
      }
      String path = args[0];
      File input = new File(path);
      Scanner reader = new Scanner(input);

      String line = reader.nextLine();
      line = line.trim().replaceAll(" +", "");
      String[] timeS = line.split(":");
      Long[] time = new Long[timeS.length-1];
      for(int i = 1; i < timeS.length; i++){
        time[i-1] = Long.valueOf(timeS[i]);
      }
      line = reader.nextLine();
      line = line.trim().replaceAll(" +", "");
      String[] distanceS = line.split(":");
      Long[] distance = new Long[distanceS.length-1];
      for(int i = 1; i < timeS.length; i++){
        distance[i-1] = Long.valueOf(distanceS[i]);
      }

      Long sum = 1L;

      for(int i = 0; i < time.length; i++){
        Long t = time[i];
        Long d = distance[i];
        Long x = 1L;
        while(x*(t-x)<=d){
          x++;
        }
        sum *= (t-x)-x+1;
      }

      System.out.println(sum);

      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }
}
