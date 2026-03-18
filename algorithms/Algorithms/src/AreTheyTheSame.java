import java.util.Arrays;

public class AreTheyTheSame {
//    https://www.codewars.com/kata/550498447451fbbd7600041c
    /*
    Given two arrays a and b write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have the "same" elements, with the same multiplicities (the multiplicity of a member is the number of times it appears). "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.

Examples
Valid arrays
a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
comp(a, b) returns true because b:
b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]
     */
public static void main(String[] args) {
    int[] arr1 = {121, 144, 19, 161, 19, 144, 19, 11};
    int[] arr2 = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
    System.out.println(isSquareOf(arr1,arr2)); //exp.out: true

    int[] arr3 = {121, 144, 19, 161, 19, 144, 19, 11};
    int[] arr4 = {132, 14641, 20736, 361, 25921, 361, 20736, 361};
    System.out.println(isSquareOf(arr3,arr4)); //exp.out: false
}

public static boolean isSquareOf(int[] arr1, int[] arr2){
    if (arr1==null||arr2==null){return false;}
    if(arr1.length==0||arr2.length==0){return false;}
    if (arr1.length!=arr2.length){return false;}

//    Arrays.sort(arr1);     Arrays.sort(arr2);
    for (int i=0;i<arr1.length-1;i++){
        for (int y=i+1;y<arr1.length;y++){
            if (arr1[i]>arr1[y]){
                int interim = arr1[i];
                arr1[i]=arr1[y];
                arr1[y]=interim;
            }
            if (arr2[i]>arr2[y]){
                int interim = arr2[i];
                arr2[i]=arr2[y];
                arr2[y]=interim;
            }
        }
    }

    for(int i=0;i<arr1.length;i++){
        if (arr1[i]*arr1[i]!=arr2[i]){
            return false;
        }
    }

    return true;
}
}
