public class FindTheUniqueNumber {
    // https://www.codewars.com/kata/585d7d5adb20cf33cb000235
    /*
    There is an array with some numbers. All numbers are equal except for one. Try to find it!

findUniq([ 1, 1, 1, 2, 1, 1 ]) === 2
findUniq([ 0, 0, 0.55, 0, 0 ]) === 0.55
It’s guaranteed that array contains at least 3 numbers.

The tests contain some very huge arrays, so think about performance.
     */
    public static void main(String[] args) {
        double[] arr1 = {1, 1, 1, 2, 1, 1};
        double[] arr2 = {0, 0, 0.55, 0, 0};


        System.out.println(findUniqueNumber(arr1));//ex.out 2.0
        System.out.println(findUniqueNumber(arr2));//exp. out 0.55
    }

    public static double findUniqueNumber(double[] arr){
        double unique = 0.0;
        if (arr.length==0){return 0;}

        double first=arr[0];
        double second=arr[1];
        if (first!=second){
            if (arr[2]!=arr[0]){return arr[0];}
            else if(arr[2]!=arr[1]){return arr[1];}
        }
        else{
           for (int i = 0; i<=(arr.length+1)/4; i++){
               if (arr[i]!=first){return arr[i];}
               else if (arr[(arr.length+1)/4 +i]!=first){return arr[(arr.length+1)/4 +i];}
               else if (arr[(arr.length+1)/2+i]!=first){return arr[(arr.length+1)/2+i];}
               else if (arr[arr.length-1-i]!=first){return arr[arr.length-1-i];}
           }
        }
        return unique;
    }
}
