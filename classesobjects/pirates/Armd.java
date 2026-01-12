package pirates;

import java.util.ArrayList;
import java.util.List;

public class Armd {
    private List<PrShip> armada = new ArrayList<>();
    private String name;
    private int myBattlesWon;
    /*
    Armada
    Create an Armada class
    Contains a list of Ship
     Have an armada.war(otherArmada) method where two armada can engage in war
    it should work like merge sort
    first ship from the first armada battles the first one from the other
    the loser ship gets skipped so the next ship comes in play from the loser ship's armada
    it starts a battle with the first (not yet defeated) ship from the other armada
    whichever armada gets to the end of its ships loses the war
return true if this is the winner
 */

    public Armd() {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "CH", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Integer[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int randomA = (int) (Math.random() * alphabet.length);
        int randomD = (int) (Math.random() * digits.length);

        name = "Armada ";
        name = name.concat(String.valueOf(randomA)).concat(String.valueOf(randomD));

    }

    public boolean war(Armd otherArmada) {
        resetBattles();
        otherArmada.resetBattles();
        boolean doWeWin = false;
        List<PrShip> otherArmd = otherArmada.getArmada();
        PrShip myShip = armada.get(0);
        PrShip otherShip = otherArmd.get(0);

        for (int i = 0; i < armada.size(); i++) {
            myShip = armada.get(i);
            for (int y = 0; y < otherArmd.size(); y++) {
                otherShip = otherArmd.get(y);
                boolean weWin = myShip.battle(otherShip);
                if (weWin) {
                    registerWin();
                    i--;
                    if (y == otherArmd.size() - 1) {
                        doWeWin = true;
                        return doWeWin;
                    }
                } else {
                    otherArmada.registerWin();
                    y--;
                    if (i == armada.size() - 1) {
                        doWeWin = false;
                        return doWeWin;
                    }
                    break;
                }
            }
        }
        return doWeWin;
    }

    public String afterBattleStat() {
        String s = name;
        return s.concat(" after battle: Wins: ").concat(String.valueOf(myBattlesWon))
                .concat(" Total crew alive: ").concat(String.valueOf(crewMembersAlive()));
    }

    public void addShip() {
        PrShip ship = new PrShip();
        ship.fillShip();
        armada.add(ship);
    }

    public void fillArmada() {
        int size = (int) (Math.random() * 2) + 1;
        for (int i = 0; i < size; i++) {
            PrShip prShip = new PrShip();
            prShip.fillShip();
            addShip(prShip);
        }
    }

    public void addShip(PrShip ship) {
        armada.add(ship);
    }

    public List<PrShip> getArmada() {
        List<PrShip> copy = new ArrayList<>(armada); //shallow copy
        return copy;
    }

    private int crewMembersAlive() {
        int totalAlive = 0;
        if (armada.size() == 0) {
            return 0;
        }
        for (int i = 0; i < armada.size(); i++) {
            PrShip currentShip = armada.get(i);
            int crewAlive = currentShip.crewAlive();
            totalAlive += crewAlive;
        }
        return totalAlive;
    }

    @Override
    public String toString() {
        return name.concat(": Ship count: ").concat(String.valueOf(armada.size()))
                .concat(" Total crew alive: ").concat(String.valueOf(crewMembersAlive()));
    }

    public void registerWin() {
        myBattlesWon++;
    }

    public void resetBattles() {
        myBattlesWon = 0;
    }

    public String getName() {
        return name;
    }
}
