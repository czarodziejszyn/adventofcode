import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

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
      int x = 0;
      ArrayList<String> lines = new ArrayList<>();

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        lines.add(line);
      }

      char[][] plan = new char[lines.size()][];

      for(int i = 0; i < lines.size(); i++){
        plan[i] = lines.get(i).toCharArray();
      }

      for(int i = 0; i < plan.length; i++){
        for(int j = 0; j < plan[i].length; j++){
          if(Character.isDigit(plan[i][j])){
            int numLength = 0;
            while(j < plan[i].length){
              if(Character.isDigit(plan[i][j])){
                numLength++;
                j++;
              }
              else{
                break;
              }
            }

            j-=numLength;
            int isAdjacent = 0;
            int number = 0;
            for(int k = 0; k < numLength; k++){
              number *= 10;
              number += Character.getNumericValue(plan[i][j]);
              isAdjacent = checkAround(plan, i, j, -1, 0, isAdjacent);
              isAdjacent = checkAround(plan, i, j, -1, 1, isAdjacent);
              isAdjacent = checkAround(plan, i, j, 0, 1, isAdjacent);
              isAdjacent = checkAround(plan, i, j, 1, 1, isAdjacent);
              isAdjacent = checkAround(plan, i, j, 1, 0, isAdjacent);
              isAdjacent = checkAround(plan, i, j, 1, -1, isAdjacent);
              isAdjacent = checkAround(plan, i, j, 0, -1, isAdjacent);
              isAdjacent = checkAround(plan, i, j, -1, -1, isAdjacent);
              j++;
            }

            if(isAdjacent == 1){
              sum += number;
            }
          }
        }
      }

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }

  public static int checkAround(char[][] plan, int x, int y, int ver, int hor, int isAdjacent){
    int h = 1;
    while(isAdjacent == 0 && h == 1){
      x+=ver;
      y+=hor;  
      if(x < 0 || x >= plan.length || y >= plan[x].length || y < 0){
        break;
      }
      if(!Character.isDigit(plan[x][y]) && plan[x][y]!='.'){
        isAdjacent = 1;
      }
      else if(Character.isDigit(plan[x][y])){
        break;
      }
      h = 0;
    }

    return isAdjacent;
  }
}
