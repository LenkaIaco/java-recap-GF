package twentyPlusOne;

import java.util.Scanner;

public class Game {

    public int generateNumber() {
        int minNumIncl = 15;
        int maxNumIncl = 21;
        return minNumIncl + (int) (Math.random() * (maxNumIncl + 1 - minNumIncl));
    }

    public void play() {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("To draw first card, press 0");
        while (sum < 21) {
            int i = sc.nextInt();

            if (i == 0) {
                int card = generateNumber();
                sum = sum + card;
                System.out.println("Your card: " + card);
                System.out.println("Your sum: " + sum);
                if (sum == 21) {
                    System.out.println("Congratulations, you win!");
                    return;
                } else if (sum < 21) {
                    System.out.println("To draw another card, press 0. To stop playing, press 1.");
                } else {
                    System.out.println("You have lost.");
                    return;
                }
            } else if (i == 1) {
                System.out.println("Your final sum is: " + sum);
                if (sum != 21) {
                    System.out.println("You have lost.");
                } else {
                    System.out.println("Congratulations, you win!");
                }
                return;
            } else {
                System.out.println("Invalid number");
            }

        }
    }
}

