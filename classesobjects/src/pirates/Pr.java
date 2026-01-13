package pirates;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

/*
drinkSomeRum() - intoxicates the Pirate by one
howsItGoingMate() - when called, the Pirate replies:
        if drinkSomeRum() was called less than 4 times:
        "Pour me anudder!"
        else:
        "Arghh, I'ma Pirate. How d'ya d'ink its goin?". Then the pirate passes out and sleeps it off (gets rid of the intoxication).
If you manage to get this far, then you can try to do the following.

brawl(Pirate) - where pirate fights another pirate (if both of them are alive):
there is 1/3 chance that this dies, the other dies or they both pass out.
die() - this kills off the pirate. When a pirate is dead, every method simply results in: he's dead.
And... if you get that far...

Add a parrot.
 */
public class Pr {
    private int intoxication;
    private boolean dead;
    private String name;
    String[] parrot;

    public Pr() {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "CH", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Integer[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int letterIndex = (int) (Math.random() * alphabet.length);
        int digitIndex = (int) (Math.random() * digits.length);

        String name = "".concat(alphabet[letterIndex]).concat(String.valueOf(digits[digitIndex]));
        this.name = name;

        parrot = new String[]{
                "Pour me anudder!",
                "Arghh, I'ma Pirate. How d'ya d'ink its goin?",
                name + "'s dead",
                name + " passing out"
        };
    }

    public void setDead() {
        dead = true;
        System.out.println(parrot[2]);
    }

    public void drinkSomeRum() {
        if (!dead) {
            intoxication++;
            if (intoxication < 4) {
                System.out.println(parrot[0]);
            } else {
                System.out.println(parrot[1]);
                sleep();
            }
        } else {
            System.out.println(parrot[2]);
        }
    }

    public void sleep() {
        if (!dead) {
            intoxication = 0;
        } else {
            System.out.println(parrot[2]);
        }
    }

    public void brawl(Pr otherPirate) {
        int oneInThree = ((int) (Math.random() * 3)) + 1;
        if (oneInThree == 3) {
            setDead();
        } else if (oneInThree == 2) {
            otherPirate.setDead();
            System.out.println(parrot[2]);
        } else {
            passOut();
            otherPirate.passOut();
        }

    }

    public void passOut() {
        System.out.println(parrot[3]);
        sleep();
    }

    public String getName() {
        if (!dead) {
            return name;
        } else {
            return parrot[2];
        }
    }

    public boolean isDead() {
        return dead;
    }

    public int getIntoxication() {
        return intoxication;
    }

}
