package pirates;

public class WrApp {
    public static void main (String[] args){
        Armd armada1 = new Armd();
        armada1.fillArmada();

        Armd armada2 = new Armd();
        armada2.fillArmada();

        System.out.println(armada1.toString());
        System.out.println(armada2.toString());
       String winner = armada1.war(armada2) ? "Winner: "+armada1.getName() : "Winner: " + armada2.getName();
        System.out.println(winner);
        System.out.println(armada1.afterBattleStat());
        System.out.println(armada2.afterBattleStat());

    }
}
