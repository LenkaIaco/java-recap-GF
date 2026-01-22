package unitTesting.fibonacci;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FiboTest {
    @Test
    void fibonacciOf4Returns3(){
        int three = 3;
        assertEquals(three, Fibo.fibonacci(4));
    }

    @Test
    void fibonacciOf14Returns377(){

        assertEquals(377, Fibo.fibonacci(14));
    }

    @Test
    void fibonacciOfZeroReturnsZero(){
        assertEquals(0,Fibo.fibonacci(0));
    }

    @Test
    void fibonacciOfOneReturnsOne(){
        assertEquals(1, Fibo.fibonacci(1));
    }
}
