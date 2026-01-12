package counter;

import org.junit.jupiter.api.Test;

// assertions are full of static methods, thus static import needed
import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
Counter counter = new Counter();
Counter counter2 = new Counter(5);
    @Test
    void getCounterAfterDefaultConstructorReturnsZero() {
       assertEquals(counter.getCounter(), 0);
    }

    @Test
    void getCounterAfterParameterizedConstructorReturnsParamValue(){
        assertEquals(counter2.getCounter(),5);
    }

    @org.junit.jupiter.api.Test
    void addWithoutParameterIncreasesCounterBy1() {
        counter.add();
        counter2.add();
        assertEquals(1, counter.getCounter());
        assertEquals(6, counter2.getCounter());
    }


    @org.junit.jupiter.api.Test
    void addWithParameterValueIncreasesCounterByValue () {
    counter.add(5);
        assertEquals(5, counter.getCounter());
    }


    @org.junit.jupiter.api.Test
    void resetSetsCounterToFirstHistoricValue() {
        counter.add();
        counter2.add();
        counter.reset();
        counter2.reset();
        assertEquals(counter.getInit(), counter.getCounter());
        assertEquals(counter2.getInit(), counter2.getCounter());
    }
}