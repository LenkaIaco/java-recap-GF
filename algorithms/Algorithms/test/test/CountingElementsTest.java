package test;

import designGurus.CountingElements;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountingElementsTest {

    @Test
    public void countGreaterByOneReturns_0_ForArraySize1(){
        assertEquals(CountingElements.countGreaterByOne(new int[1]),0);
    }

    @Test
    public void countGreaterByOneReturns2For2greaterValues(){
        assertEquals(CountingElements.countGreaterByOne(new int[]{1,2,3}),2);
    }
}