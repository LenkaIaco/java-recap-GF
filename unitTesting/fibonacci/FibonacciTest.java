package unitTesting.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    Fibonacci exampleClass;

    @BeforeEach
    public void init() {
        exampleClass = new Fibonacci();
    }

    @Test
    void fibonacciIndex14ReturnsValue377() {
        int targetValue = 377;
        int targetIndex = 14;
        assertEquals(targetValue, exampleClass.fibonacciValue(targetIndex));
    }

    @Test
    void fibonacciInputZeroReturnsValueZero() {
        int targetValue = 0;
        int targetIndex = 0;
        assertEquals(targetValue, exampleClass.fibonacciValue(targetIndex));
    }

    @Test
    void fibonacciNegativeInputReturnsValueZero() {
        int targetValue = 0;
        int targetIndex = -1;
        assertEquals(targetValue, exampleClass.fibonacciValue(targetIndex));
    }

    @Test
//  https://howtodoinjava.com/junit5/expected-exception-example/
    void fibonacciNegativeParameterThrowsUOException() {
        UnsupportedOperationException testUOException = assertThrows(UnsupportedOperationException.class, () -> {
            exampleClass.fibonacciValue(-1);
        });
    }

//  'null' is referenced with Objects (Integer, String, ArrayList, ...), i.e. the object does not have an assigned value
//  Primitive types are plain data. Objects(and variables), on the other hand, are just pointers to where the data is stored
//The difference of Primitive and Object Reference is Primitive variable store the actual values, Whereas object reference variable
//  store the address of the object they refer to, in this case in object reference if there is no address it will pass to "null".
// Source: https://stackoverflow.com/questions/11047276/why-cant-primitive-data-types-be-null-in-java

//  void fibonacciNullValueReturnsZero(){
//    assertEquals(0, exampleClass.fibonacciValue(null));
//  }
}