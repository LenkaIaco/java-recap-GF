package unitTesting.cowsAndBulls;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//char c = '3';
//    Integer integer = Integer.valueOf(Character.valueOf(c).toString());
//    System.out.println(integer);


//      ArrayList<Integer> numberToBeGuessed = new ArrayList<>();
//      for (int i = 0; i < 4 ; i++) {
//          numberToBeGuessed.add((int)(Math.random()*10));
//      }
////      [8, 5, 1, 3]
//      System.out.println(numberToBeGuessed.toString());

//        String s = "";
//        for (int i = 0; i < 4; i++) {
//            s = s + String.valueOf((int) (Math.random() * 10));
//        }
//        System.out.println(s);
//    }

        CowsAndBulls newGame = new CowsAndBulls();
        String result = newGame.guessTheNumber("013");
        System.out.println(result);
    }
}