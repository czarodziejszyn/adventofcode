import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class part2{
  public static void main(String[] args){
    try{
      if(args.length == 0){
        return;
      }
      String path = args[0];
      File input = new File(path);
      Scanner reader = new Scanner(input);
      Map<String, Integer> scores = new HashMap<>();
      int sum = 0;
      ArrayList<String> five = new ArrayList<>();
      ArrayList<String> four = new ArrayList<>();
      ArrayList<String> full = new ArrayList<>();
      ArrayList<String> three = new ArrayList<>();
      ArrayList<String> twoPair = new ArrayList<>();
      ArrayList<String> onePair = new ArrayList<>();
      ArrayList<String> high = new ArrayList<>();
      int num = 0;

      while(reader.hasNextLine()){
        String line = reader.nextLine();
        String[] words = line.split(" ");
        String cards = words[0];
        int bet = Integer.valueOf(words[1]);
        num++;

        scores.put(cards, bet);

        char[] elements = cards.toCharArray();
        Arrays.sort(elements);
        ArrayList<Integer> points = new ArrayList<>();
        int jokersIndex = -1;

        for(int i = 0; i < elements.length; i++){
          points.add(1);
          if(elements[i] == 'J'){
            jokersIndex = points.size()-1;
          }
          while(i < elements.length-1 && elements[i+1] == elements[i]){
            i++;
            points.set(points.size()-1, points.get(points.size()-1)+1);
          }
        }
        int jokers = 0;
        if(jokersIndex != -1){
          jokers = points.get(jokersIndex);
        }
        Collections.sort(points);

        switch (jokers){
          case 4:
            points.remove(1);
            points.set(0, 5);
            break;
          case 3:
            points.remove(points.size()-1);
            points.set(points.size()-1, points.get(points.size()-1)+3);
            break;
          case 2:
            if(points.get(0) == 2){
              points.set(0, 5);
              points.remove(1);
            }
            else{
              points.remove(points.size()-1);
              points.set(points.size()-1, points.get(points.size()-1)+2);
            }
            break;
          case 1:
            points.remove(0);
            points.set(points.size()-1, points.get(points.size()-1)+1);
            break;
        }

        if(points.get(0) == 5){
          five.add(cards);
        }
        else if(points.get(0) == 1 && points.get(1) == 4){
          four.add(cards);
        }
        else if(points.get(0) == 2){
          full.add(cards);
        }
        else if(points.get(2) == 3){
          three.add(cards);
        }
        else if(points.get(1) == 2){
          twoPair.add(cards);
        }
        else if(points.get(3) == 2){
          onePair.add(cards);
        }
        else{
          high.add(cards);
        }
      }

      Comparator<String> customAlphabetComparator = new CustomAlphabetComparator();
      Collections.sort(five, customAlphabetComparator);
      Collections.sort(four, customAlphabetComparator);
      Collections.sort(full, customAlphabetComparator);
      Collections.sort(three, customAlphabetComparator);
      Collections.sort(twoPair, customAlphabetComparator);
      Collections.sort(onePair, customAlphabetComparator);
      Collections.sort(high, customAlphabetComparator);

      sum = countPoints(five, scores, num, sum);
      num -= five.size();
      sum = countPoints(four, scores, num, sum);
      num -= four.size();
      sum = countPoints(full, scores, num, sum);
      num -= full.size();
      sum = countPoints(three, scores, num, sum);
      num -= three.size();
      sum = countPoints(twoPair, scores, num, sum);
      num -= twoPair.size();
      sum = countPoints(onePair, scores, num, sum);
      num -= onePair.size();
      sum = countPoints(high, scores, num, sum);

      System.out.println(sum);
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Dupa\n");
      e.printStackTrace();
    }
  }

  public static int countPoints(ArrayList<String> decks, Map<String, Integer> scores, int num, int sum){
    for(int i = 0; i < decks.size(); i++){
      sum += scores.get(decks.get(i)) * num;
      num--;
    }
    return sum;
  }
}

class CustomAlphabetComparator implements Comparator<String>{
  private final String customOrder = "AKQT98765432J";

  @Override
  public int compare(String o1, String o2){
    for(int i = 0; i < o1.length(); i++){
      char char1 = o1.charAt(i);
      char char2 = o2.charAt(i);

      int index1 = customOrder.indexOf(char1);
      int index2 = customOrder.indexOf(char2);

      if(index1 != index2){
        return Integer.compare(index1, index2);
      }
    }

    return Integer.compare(o1.length(), o2.length());
  }
}
