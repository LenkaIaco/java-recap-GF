package gf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    // https://www.codewars.com/kata/5226eb40316b56c8d500030f
    /*
Pascal's triangle is a triangular array where each row contains one more number, and
each number(except the edge numbers) a sum of two numbers above it
        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1

Write a function that, given a depth n, returns n top rows of Pascal's Triangle flattened into a one-dimensional list/array.


     */
    public static void main(String[] args) {
long[] level3 = {1L,1L,1L,1L,2L,1L};
long[] level4 = {1L,1L,1L,1L,2L,1L,1L,3L,3L,1L};
long[] level5 = {1L,1L,1L,1L,2L,1L,1L,3L,3L,1L,1L,4L,6L,4L,1L};

        System.out.println(Arrays.toString(generate(3))); //equal level3
        System.out.println(Arrays.toString(generate(4))); //equal level4
        System.out.println(Arrays.toString(generate(5))); //equal level5

    }

    public static long[] generate(int level) {
        if (level<1){return null;}
if (level ==1){return new long[]{1L};}
if (level==2){return new long[]{1L,1L,1L};}
List<List<Long>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1L)));
        list.add(new ArrayList<>(Arrays.asList(1L, 1L)));

    int length = 3;
    for (int i =2; i<level; i++){
        List<Long> currLevel = new ArrayList<>();
        for (int y=0;y<length;y++){
            if (y==0||y==length-1){
                currLevel.add(1L);
            }else{
                List<Long> prev = list.get(i-1);
                currLevel.add(prev.get(y-1)+prev.get(y));
            }
        }
        list.add(currLevel);
        length++;
        }

// converting results to long[]
        int arrSize = 0;
        for (int i = 1; i<=level;i++){
            arrSize=arrSize+i;
        }
        long[]result=new long[arrSize];
        int index = 0;
        for (int i=0; i<list.size();i++){
            for (int y=0;y<list.get(i).size();y++){
                result[index] = list.get(i).get(y);
                index++;
            }
        }
        return result;
    }

}
