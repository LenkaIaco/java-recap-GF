import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
        /**
         * Exercise
         * Write a program which selected a number between 1 and 100 at random.
         * The player is then asked to enter a guess. If the guess wrong the program gives feedback and keeps
         * asking for new guesses until one is correct.
         *
         * Make the range customizable (ask for it before starting the guessing).
         * You can add lives. (optional)
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("Default range: 1 - 100. Enter a guessing range under 100, within which you wish to guess {e.g.: 50} ");
        int rangeUser = scan.nextInt();
        System.out.println("Enter your first guess(You have 5 tries in total).");
        int guessUser = scan.nextInt();

        int lives = 5;
        int random = (int)(Math.random()*100);
        while (random >=rangeUser && random !=0 ){
            random = (int)(Math.random()*100);
        }
        System.out.println(random);


                int i = lives;
                    while (random != guessUser && i >1) {
                    if (guessUser > random ) {
                        System.out.println("Enter a smaller number...");
                        i = i-1;
                        System.out.println("Number of tries left: " + (i));
                        guessUser = scan.nextInt();
                    } else if ( guessUser < random ) {
                        System.out.println("Enter a larger number...");
                        i = i-1;
                        System.out.println("Number of tries left: " + (i));
                        guessUser = scan.nextInt();
                    }


                }


         if (guessUser == random) {System.out.println("Congratulations, " + random + " is the correct guess!");
         }else  {System.out.println("Sorry, you have exhausted the maximum number of tries!");}
    }
}
