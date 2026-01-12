package pirates;

public class Pirate {
    private int intoxication;
    private int lives;
    private String parrot;

    public Pirate() {
        intoxication = 0;
        lives = 1;
        parrot = "Yo, Ho, Ho (And a Bottle of Rum)";
    }

    public int intoxicationLevel() {
        return intoxication;
    }

    public int getLives() {
        return lives;
    }

    public void howsItGoingParrot() {
        if (lives == 0) {
            System.out.println("the parrot died protecting its master");
        } else {
            System.out.println(parrot);
        }
    }

    public void drinkSomeRum() {
        if (lives == 0) {
            System.out.println("he's dead");
        } else {
            intoxication++;
        }
    }

    public void sleep() {
        if (lives == 0) {
            System.out.println("he's dead");
        } else {
            intoxication = 0;
        }
    }

    public void die() {
        if (lives == 0) {
            System.out.println("he's dead");
        } else {
            lives = 0;
        }
    }

    public void howsItGoingMate() {
        if (lives == 0) {
            System.out.println("he's dead");
        } else {
            if (intoxication < 4) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                sleep();
                System.out.println("the pirate fell asleep");
            }
        }
    }

    public void brawl(Pirate otherPirate) {
        if (lives == 0) {
            System.out.println("he's dead");
        } else {
            if (lives > 0 && otherPirate.getLives() > 0) {
                int chance = (int) (Math.random() * 3) + 1;
                if (chance == 1) {
                    this.die();
                } else if (chance == 2) {
                    otherPirate.die();
                } else if (chance == 3) {
                    System.out.println("Both pirates passed out");
                }
            }
        }
    }

}
