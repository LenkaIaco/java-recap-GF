package farm;

import animal.Animal;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FarmTest {
    int limit = 10;
    Farm farm = new Farm(limit);

@Test
public void breedIncreasesAnimalCountByOne(){
    int sizeBefore = farm.getAnimals().size();
    farm.breed();
    int sizeAfter = farm.getAnimals().size();
    assertEquals(sizeBefore+1,sizeAfter);
}

public void breedDoesNotSurpassFarmLimit(){
    int limit = farm.getLimit();
    Farm farm = new Farm(limit);
    int size = farm.getAnimals().size();

    for (int i=0; i<limit+1;i++){
        farm.breed();
    }

    int size2 = farm.getAnimals().size();

    assertEquals(size, size2);
}

public void sellPicksLeastHungryAnimal(){
    for (int i=0; i<limit; i++){
        farm.breed();
    }

    List<Animal> animals = farm.getAnimals();
      Animal fifthAnimal = animals.get(4);
      fifthAnimal.eat();

      Animal lastAnimal = animals.get(animals.size()-1);
      lastAnimal.drink();

    farm.sell();

    assertEquals(false,animals.contains(fifthAnimal));
    assertEquals(true,animals.contains(lastAnimal));

}


}
