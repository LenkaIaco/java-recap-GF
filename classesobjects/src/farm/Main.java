package farm;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm(10);
        for(int i=0; i<11;i++){
            farm.breed();
        }

        for (int i = 0; i<10;i++){
            farm.getAnimals().get(0).eat();
        }

        System.out.println(farm.getAnimals().size());
        System.out.println(farm.getAnimals());
        farm.sell();
        System.out.println(farm.getAnimals());


            farm.getAnimals().get(0).drink();

        System.out.println(farm.getAnimals());
        farm.sell();
        System.out.println(farm.getAnimals());



    }

}
