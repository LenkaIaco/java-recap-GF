package pirates;

import java.util.ArrayList;

public class Armada {
    private ArrayList<Ship> armada;

    public Armada() {
        armada = new ArrayList<>();
    }

    public void fillArmada() {
        for (int i = 15; i <= (int) (Math.random()* 25) + 15; i++) {
            Ship ship = new Ship();
            ship.fillShip();
            armada.add(ship);
        }
    }

    public int getArmadaSize() {
        return armada.size();
    }

    public int getTotalShipScore() {
        int totalScore = 0;
        for (int i = 0; i < armada.size(); i++) {
            totalScore += armada.get(i).calculateShipScore();
        }
        return totalScore;
    }

    public boolean war(Armada anotherArmada) {

        for (int i = 0; i < armada.size(); i++) {
            if (armada.size() != 0) {
                for (int j = 0; j < anotherArmada.getArmadaSize(); j++) {
                    if (anotherArmada.getArmadaSize() != 0) {
                        if (armada.get(i).battle(anotherArmada.armada.get(j))) {
                            anotherArmada.armada.remove(j);
                            j--;
                        } else {
                            armada.remove(i);
                            i--;
                            break;
                        }
                    }
                }
            }

        }
        return armada.size() > anotherArmada.getArmadaSize();
    }

    @Override
    public String toString() {
        return "Armada's ships: " + getArmadaSize() + "; armada's score: " + getTotalShipScore();
    }

}
