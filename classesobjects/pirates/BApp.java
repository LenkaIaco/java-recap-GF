package pirates;

public class BApp {
    public static void main(String[] args){
        PrShip ship1 = new PrShip();
        ship1.fillShip();
        ship1.getCaptain().drinkSomeRum();
        PrShip ship2 = new PrShip();
        ship2.fillShip();

        System.out.println(ship1.toString());
        System.out.println(ship2.toString());
        System.out.println("\nBattle starts: \n");
        boolean ship1Won = ship1.battle(ship2);
        String winner = ship1Won ? ship1.getName() : ship2.getName();
        System.out.println("\nBattle ends, winner is: " + winner + "\n");

        System.out.println(ship1.toString());
        System.out.println(ship2.toString());
    }
}
