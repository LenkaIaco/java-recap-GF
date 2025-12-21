package Arrays.Excercises;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        // - Create an array variable named `numbers`
        //   with the following content: `[3, 4, 5, 6, 7]`
        // - Reverse the order of the elements of `numbers` programmatically
        // - Print the elements of the reversed `numbers`:
        //   [7, 6, 5, 4, 3]


 int[] numbers2 = {3,4,5,6,7};
int i = 0;
int y = numbers2.length-1-i;

while (i<y){
    int holdingVar = numbers2[i];
    numbers2[i] = numbers2[y];
    numbers2[y]=holdingVar;
    i++;
    y--;
}
        System.out.println(Arrays.toString(numbers2));

//        int[] numbers = {3,4,5,6,7};
//        int[] numberStorage = new int[numbers.length];
//        for (int i = 0; i < numbers.length; i++) {
//         if (i!= numbers.length-1) { numberStorage[i] = numbers[numbers.length-1-i];}
//           else {numberStorage[i] = numbers[numbers.length-1-i];
//             for (int j = 0; j < numberStorage.length ; j++) {
//                 numbers[j] = numberStorage[j];
//             }
//              }
//           };
//
//        System.out.println(Arrays.toString(numbers));
    }
}
