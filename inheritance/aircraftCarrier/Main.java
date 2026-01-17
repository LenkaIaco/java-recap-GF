package aircraftCarrier;

public class Main {
    public static void main(String[] args) {
        AircraftCarrier carrier1 = new AircraftCarrier(1000, 1000);
        AircraftCarrier carrier2 = new AircraftCarrier(500,1000);

        int random1 =  (int) (Math.random()*10);
        for (int i = 0; i<random1;i++){
            int ammo = (int) (Math.random()*100);
            Aircraft f16 = new F16();
            carrier1.add(f16);
        }
        int random2 =  (int) (Math.random()*10);
        for (int i = 0; i<random2;i++){
            Aircraft f35 = new F35();
            carrier1.add(f35);
        }
        int random3 =  (int) (Math.random()*10);
        for (int i = 0; i<random3;i++){
            Aircraft f16 = new F16();
            carrier2.add(f16);
        }
        int random4 =  (int) (Math.random()*10);
        for (int i = 0; i<random4;i++){
            Aircraft f35 = new F35();
            carrier2.add(f35);
        }

        carrier1.fill();
        carrier2.fill();

        System.out.println(carrier1.getStatus());
        System.out.println(carrier2.getStatus());

        carrier2.fight(carrier1);

        System.out.println(carrier1.getStatus());
        System.out.println(carrier2.getStatus());
    }
}
