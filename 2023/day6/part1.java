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

      String line = reader.nextLine();
      line = line.trim().replaceAll(" +", " ");
      String[] timeS = line.split(" ");
      int[] time = new int[timeS.length-1];
      for(int i = 1; i < timeS.length; i++){
        time[i-1] = Integer.valueOf(timeS[i]);
      }
      line = reader.nextLine();
      line = line.trim().replaceAll(" +", " ");
      String[] distanceS = line.split(" ");
      int[] distance = new int[distanceS.length-1];
      for(int i = 1; i < timeS.length; i++){
        distance[i-1] = Integer.valueOf(distanceS[i]);
      }

      int sum = 1;

      for(int i = 0; i < time.length; i++){
        int t = time[i];
        int d = distance[i];
        int x = 1;
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
