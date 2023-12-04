import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

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
          if(plan[i][j] == '*'){
            int NW, NE, SE, SW;
            NW = 0;
            NE = 0;
            SW = 0;
            SE = 0;
            int N = checkAround(plan, i, j, -1, 0, 0);
            if(N == 0){
              NE = checkAround(plan, i, j, -1, 1, 0);
              NW = checkAround(plan, i, j, -1, -1, 0);
            }
            int E = checkAround(plan, i, j, 0, 1, 0);
            int S = checkAround(plan, i, j, 1, 0, 0);
            if(S == 0){
              SE = checkAround(plan, i, j, 1, 1, 0);
              SW = checkAround(plan, i, j, 1, -1, 0);
            }
            int W = checkAround(plan, i, j, 0, -1, 0);

            int number = 0;
            if(N + NE + E + SE + S + SW + W + NW == 2){
              int num = 1;
              if(N == 1){
                number = 0;
                int x = i-1;
                int y = j;
                while(Character.isDigit(plan[x][y]) && y >= 0){
                  y--;
                }
                y++;
                while(Character.isDigit(plan[x][y]) && y < plan[i].length){
                  number *= 10;
                  number += Character.getNumericValue(plan[x][y]);
                  y++;
                  if(y >= plan[i].length){
                    break;
                  }
                }
                num *= number;
                System.out.println(number);
              }
              if(NE == 1){
                number = 0;
                int x = i-1;
                int y = j+1;
                while(Character.isDigit(plan[x][y]) && y >= 0){
                  y--;
                }
                y++;
                while(Character.isDigit(plan[x][y]) && y < plan[i].length){
                  number *= 10;
                  number += Character.getNumericValue(plan[x][y]);
                  y++;
                  if(y >= plan[i].length){
                    break;
                  }
                }
                num *= number;
                System.out.println(number);
              }
              if(E == 1){
                number = 0;
                int x = i;
                int y = j+1;
                while(Character.isDigit(plan[x][y]) && y >= 0){
                  y--;
                }
                y++;
                while(Character.isDigit(plan[x][y]) && y < plan[i].length){
                  number *= 10;
                  number += Character.getNumericValue(plan[x][y]);
                  y++;
                  if(y >= plan[i].length){
                    break;
                  }
                }
                num *= number;
                System.out.println(number);
              }
              if(SE == 1){
                number = 0;
                int x = i+1;
                int y = j+1;
                while(Character.isDigit(plan[x][y]) && y >= 0){
                  y--;
                }
                y++;
                while(Character.isDigit(plan[x][y]) && y < plan[i].length){
                  number *= 10;
                  number += Character.getNumericValue(plan[x][y]);
                  y++;
                  if(y >= plan[i].length){
                    break;
                  }
                }
                num *= number;
                System.out.println(number);
              }
              if(S == 1){
                number = 0;
                int x = i+1;
                int y = j;
                while(Character.isDigit(plan[x][y]) && y >= 0){
                  y--;
                }
                y++;
                while(Character.isDigit(plan[x][y]) && y < plan[i].length){
                  number *= 10;
                  number += Character.getNumericValue(plan[x][y]);
                  y++;
                  if(y >= plan[i].length){
                    break;
                  }
                }
                num *= number;
                System.out.println(number);
              }
              if(SW == 1){
                number = 0;
                int x = i+1;
                int y = j-1;
                while(Character.isDigit(plan[x][y]) && y >= 0){
                  y--;
                }
                y++;
                while(Character.isDigit(plan[x][y]) && y < plan[i].length){
                  number *= 10;
                  number += Character.getNumericValue(plan[x][y]);
                  y++;
                  if(y >= plan[i].length){
                    break;
                  }
                }
                num *= number;
                System.out.println(number);
              }
              if(W == 1){
                number = 0;
                int x = i;
                int y = j-1;
                while(Character.isDigit(plan[x][y]) && y >= 0){
                  y--;
                }
                y++;
                while(Character.isDigit(plan[x][y]) && y < plan[i].length){
                  number *= 10;
                  number += Character.getNumericValue(plan[x][y]);
                  y++;
                  if(y >= plan[i].length){
                    break;
                  }
                }
                num *= number;
                System.out.println(number);
              }
              if(NW == 1){
                number = 0;
                int x = i-1;
                int y = j-1;
                while(y >= 0 && Character.isDigit(plan[x][y])){
                  y--;
                }
                y++;
                while(Character.isDigit(plan[x][y]) && y < plan[i].length){
                  number *= 10;
                  number += Character.getNumericValue(plan[x][y]);
                  y++;
                  if(y >= plan[i].length){
                    break;
                  }
                }
                num *= number;
                System.out.println(number);
              }
              System.out.println(num);
              sum += num;
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
      if(Character.isDigit(plan[x][y])){
        isAdjacent = 1;
      }
      else if(!Character.isDigit(plan[x][y])){
        break;
      }
      h = 0;
    }

    return isAdjacent;
  }
}
