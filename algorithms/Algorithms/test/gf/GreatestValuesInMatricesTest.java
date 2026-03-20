package gf;

import static org.junit.jupiter.api.Assertions.*;

import  org.junit.jupiter.api.Test;

import java.util.Arrays;

class GreatestValuesInMatricesTest {

int[][] matrix1 =  {
        {1,1,1},
        {2,2,2},
        {3,3,4}
};
int[][] matrix2 =  {
            {2,2,2},
            {1,1,1},
            {4,3,3}
    };

int[][] matrix3 = {
        {2,2,2},
        {2,2,2},
        {4,3,4}
};

    @Test
   public void mergeMatrixInputNullReturnsNull (){
assertEquals(null, GreatestValuesInMatrices.mergeMatrix(null, matrix2));
    }

    @Test
    public void mergeMatrixTwoInputsReturnsOneGreaterValueMatrix(){
        assertEquals(true, Arrays.deepEquals(matrix3, GreatestValuesInMatrices.mergeMatrix(matrix1,matrix2)));
    }
}