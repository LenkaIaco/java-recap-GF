package pirates;

public class WarApp {
    public static void main(String[] args) {
        Armada ar1 = new Armada();
        ar1.fillArmada();
        Armada ar2 = new Armada();
        ar2.fillArmada();

        System.out.println("armada 1 before battle: " + ar1);
        System.out.println("armada 2 before battle: " + ar2);

        System.out.println(" 1st armada wins? " + String.valueOf( ar1.war(ar2) ) );

        System.out.println("armada 1 after battle: " + ar1);
        System.out.println("armada 2 after battle: " + ar2);
    }
}
