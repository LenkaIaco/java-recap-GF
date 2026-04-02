package designGurus;

import java.util.*;

public class SortByFrequency {
    /*
Given an array nums containing the integers, return the resultant array after sorting it in increasing order based on
the frequency of the values.
If two numbers have the same frequency, they should be sorted in descending numerical order.
Example:
    Input: nums = [4, 4, 6, 2, 2, 2]
    ExpectedOutput: [6, 4, 4, 2, 2, 2]
    Justification: Here, '6' appears once, '4' appears twice, and '2' appears three times.
    Thus, numbers are first sorted by frequency and then by value when frequencies tie.
Constraints:
    1 <= nums.length <= 100
    -1000 <= nums[i] <= 1000
 */
    /*
    1. Time Complexity O(k log k), worst case (n log n)

    for (int i=0; i<freqSorted.size();i++){
           List<Integer> nums = valuesPerCount.get(freqSorted.get(i));
           nums.sort(Comparator.reverseOrder());

    - Important: frequencies iterations i  and nums size together make up n.
    They ARE NOT INTERDEPENDENT - they truncate each other. Thus, not n * log m.
    Best case, each count is siz 1 with frequencies = n(arr size)
    Worst case, a count is array-sized, thus sorting will be O(nlogn), with iteration i =1


   2. Time complexity O(n)
    - 2 innermost loops run together in all outer loops iterations n times(size of original arr)
      for (Integer n: nums){
               for (int z=0;z<counts.get(n);z++) {
                   result.add(n);
               }
--------
Total time complexity 1+ 2 :  O( O(nlogn) + n) --> simplified: O (nlogn)



    Space complexity O(n) for hashmaps and list
     */
    public static void main(String[] args) {
    int[] nums = {4, 4, 6, 2, 2, 2};
        int [] testArray = { 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8};
        int [] testArray2 = { 4, 4, 1};
        System.out.println(Arrays.toString(sortByFrequency(nums))); //exp.out: [6, 4, 4, 2, 2, 2]
        System.out.println(Arrays.toString(sortByFrequency(testArray))); //exp.out: 8,7,7,6,6,5,5,5,4,4,4
        System.out.println(Arrays.toString(sortByFrequency(testArray2))); //exp.out: 1, 4, 4

    }

    public static int[] sortByFrequency(int[] arr){
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            Integer count = counts.get(arr[i]);
            if (count==null){counts.put(arr[i],1);}
            else{counts.put(arr[i],count+1);}
        }

        Map<Integer,List<Integer>> valuesPerCount = new HashMap<>();
        for (Map.Entry<Integer, Integer> e: counts.entrySet()){
            Integer count = e.getValue();
            if (valuesPerCount.containsKey(count)){
                valuesPerCount.get(count).add(e.getKey());
            } else{
                valuesPerCount.put(count, new ArrayList<>(Arrays.asList(e.getKey())));
            }
        }

        List<Integer> freqSorted = new ArrayList<>(valuesPerCount.keySet());
        freqSorted.sort(Comparator.naturalOrder());
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<freqSorted.size();i++){
           List<Integer> nums = valuesPerCount.get(freqSorted.get(i));
           nums.sort(Comparator.reverseOrder());
           for (Integer n: nums){
               for (int z=0;z<counts.get(n);z++) {
                   result.add(n);
               }
           }
        }

        return  result.stream().mapToInt(a -> a.intValue()).toArray();
    }
}
