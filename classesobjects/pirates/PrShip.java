package pirates;

import java.util.List;
import java.util.ArrayList;

public class PrShip {
    private Pr captain;
    private List<Pr> pirates;
//    private int crewCapacity = 113;
    private int crewCapacity = 10;
    private String name;

    public PrShip(){
        pirates = new ArrayList<>();
         name = "Ship ";
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "CH", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Integer[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int alRandom = (int)(Math.random()*alphabet.length);
        int diRandom = (int)(Math.random()*digits.length);

        name = name.concat(alphabet[alRandom]).concat(String.valueOf(digits[diRandom]));

    }
    public void fillShip() {
        int size = (int) (Math.random() * crewCapacity-1)+1;
        captain = new Pr();
        pirates.add(captain);
        for (int i = 0; i < size; i++) {
            pirates.add(new Pr());
        }
    }


    @Override
    public String toString() {
        String cAlive = captain.isDead() ? "." : "is alive, rum consumed: " + captain.getIntoxication();
        String captainInfo = "";
        captainInfo = captainInfo.concat("Captain ").concat(captain.getName()).concat(cAlive);

        String pirateInfo = "Crew members alive: ";
        int crewAlive = crewAlive();

        pirateInfo = pirateInfo.concat(String.valueOf(crewAlive));

        return name +": "+ captainInfo + "\n" + pirateInfo;
    }

    public Pr getCaptain() {
        return captain;
    }

    public List<Pr> getPirates() {
        List<Pr> copyPirates = new ArrayList<>(pirates); //shallow copy
        return copyPirates;
    }

    /*
    Ships should have a method to battle other ships: ship.battle(otherShip)
should return true if the actual ship (this) wins
the ship having higher calculated score wins
calculated score: Number of alive pirates in the crew - Number of consumed rum by the captain
The loser crew has a random number of losses (deaths).
The winning captain and crew has a party: everyone drinks a random number of rum :)
     */
    public boolean battle(PrShip otherShip) {
        boolean weWin = calculateScore() > otherShip.calculateScore();

        if (weWin) {
            int battleDeaths = (int) (Math.random() * otherShip.crewAlive());
            for (int i = 0; i < otherShip.getPirates().size(); i++) {
                if (battleDeaths > 0 && !otherShip.getPirates().get(i).isDead()) {
                    otherShip.getPirates().get(i).setDead();
                    battleDeaths--;
                }
            }
            throwParty();
            return true;
        } else if (calculateScore() == otherShip.calculateScore()) {
            System.out.println("Both ships are equally strong, battle results in a tie.");
        } else {
            int battleDeaths = (int) (Math.random() * crewAlive());
            for (int i = 0; i < pirates.size(); i++) {
                if (battleDeaths > 0 && !pirates.get(i).isDead()) {
                    pirates.get(i).setDead();
                    battleDeaths--;
                }
                otherShip.throwParty();
                return false;
            }
        }
        return weWin;
    }

    public void throwParty() {
        for (Pr pirate : pirates) {
            if (!pirate.isDead()) {
                int rumRounds = (int) Math.random() * 10;
                for (int i = 0; i < rumRounds; i++) {
                    pirate.drinkSomeRum();
                }
            }
        }

    }

    public int calculateScore() {
        return crewAlive() - captain.getIntoxication();
    }

    public int crewAlive() {
        int crewAlive = 0;

        for (Pr pirate : pirates) {
            if (!pirate.isDead()) {
                crewAlive++;
            }
        }
        return crewAlive;
    }

    public String getName(){
        return name;
    }
}
