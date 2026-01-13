package diceset;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiceSetTest {

    DiceSet diceSet = new DiceSet();

    @Test
    void rollPopulatesListFied(){

       diceSet.rollSet();
       List<Integer> dsList = diceSet.getCurrentSet();

       boolean containsNull = dsList.contains(null);

       assertEquals(false, containsNull);
    }
}
