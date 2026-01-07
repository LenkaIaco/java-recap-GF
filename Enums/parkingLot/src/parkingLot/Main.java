package parkingLot;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> list = new ArrayList<>();

        Color[] ce = Color.values();
        CarType[] cte = CarType.values();
//        Create 256 Vehicles randomly and put them into a List
        for (int i = 0; i < 256; i++) {
            int colorRandom = (int) (Math.random() * 8);
            int carTypeRandom = (int) (Math.random() * 5);

            Car mc = new Car(ce[colorRandom], cte[carTypeRandom]);
            list.add(mc);
        }

//        Count and Print the number of same vehicles for each type
//        Count and Print the number of same vehicles for each color

        HashMap<CarType, Integer> carCounts = new HashMap<>();
        HashMap<Color, Integer> colorCounts = new HashMap<>();

        for (Car car : list) {
            Color color = car.color;
            CarType cartype = car.type;

            Integer carTypeCount = carCounts.get(cartype);
            Integer colorCount = colorCounts.get(color);

            if (carTypeCount == null) {
                carCounts.put(cartype, 1);
            } else {
                carCounts.put(cartype, carTypeCount + 1);
            }

            if (colorCount == null) {
                colorCounts.put(color, 1);
            } else {
                colorCounts.put(color, colorCount + 1);
            }
        }

        for (Map.Entry e : carCounts.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        for (Map.Entry e : colorCounts.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

//        Print the most frequently occurring vehicle
        Integer max = Collections.max(carCounts.values());
        for (Map.Entry e : carCounts.entrySet()) {

            if (e.getValue().equals(max)) {
                System.out.println(e.getKey());
            }
        }
    }
}
