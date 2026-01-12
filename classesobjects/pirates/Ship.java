package pirates;

import java.util.ArrayList;

public class Ship {
    Pirate captain;
    private ArrayList<Pirate> crew;

    private int shipScore;
    private String captainState;
   private int piratesAlive;

    public int calculatePiratesAlive() {
        int piratesAlive = 0;
        for (int i = 0; i < crew.size(); i++) {
            if (crew.get(i).getLives() > 0) {
                piratesAlive++;
            }
        }
        return piratesAlive;
    }


    public int calculateShipScore() {
        int shipScore = calculatePiratesAlive() - captain.intoxicationLevel();
        this.shipScore = shipScore;
        return shipScore;
    }

    public void fillShip() {
        captain = new Pirate();
        crew = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 113) + 1; i++) {
            crew.add(new Pirate());
        }
    }


    public boolean battle(Ship otherShip) {
        Ship winnerShip;
        Ship loserShip;
        if (this.shipScore > otherShip.shipScore) {
            winnerShip = this;
            loserShip = otherShip;
        } else {
            winnerShip = otherShip;
            loserShip = this;
        }

        for (int i = 0; i < winnerShip.crew.size(); i++) {
            for (int j = 0; j < (int) (Math.random() * 4); j++) {
                winnerShip.crew.get(i).drinkSomeRum();
            }
        }

        for (int j = 0; j < (int) (Math.random() * 4); j++) {
            captain.drinkSomeRum();
        }


        for (int j = 0; j < (int) (Math.random() * loserShip.crew.size()); j++) {
            loserShip.crew.get(j).die();
        }

        return winnerShip == this;
    }

    @Override
    public String toString() {
        String captainState = "";
        if (captain.getLives() == 0) {
            captainState = "dead;";
        } else {
            captainState = "alive;";
        }
        return "Captain: Rum(s) consumed: " + captain.intoxicationLevel() + ", captain state: " + captainState
                + System.lineSeparator() +
                "Pirates alive: " + String.valueOf(calculatePiratesAlive());

    }

}
