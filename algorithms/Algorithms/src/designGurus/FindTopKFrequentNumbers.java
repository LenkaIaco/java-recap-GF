package designGurus;

import java.util.*;

public class FindTopKFrequentNumbers {
    /*
    Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
Example 1:
    Input: [1, 3, 5, 12, 11, 12, 11], K = 2
    Output: [12, 11]
Example 2:
    Input [10, 20, 10, 20, 10, 20, 10, 20, 30, 40, 30, 40];
    Output [20,10]
Constraints:
    1 <= nums.length <= 105
    -105 <= nums[i] <= 105
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.
     */

    /*
    Time complexity O(nlogn) for sorting
    Space complexity O(n) for hashmap
     */

    public static void main(String[] args) {
      int[] arr = {10, 20, 10, 20, 10, 20, 10, 20, 30, 40, 30, 40};
      int[] arr2 = {1, 3, 5, 12, 11, 12, 11};
      int k = 2;

      System.out.println(Arrays.toString(maxFrequency(arr,k))); // exp.out [20,10]
      System.out.println(Arrays.toString(maxFrequency(arr2,k))); // exp.out [11,12]
    }

  public static int[] maxFrequency(int[] arr, int k){
      Map<Integer, Integer> counts = new HashMap<>();
      for (int i=0;i<arr.length;i++){
          Integer currCount = counts.get(arr[i]);
          if (currCount==null){
              counts.put(arr[i],1);
          } else{
              counts.put(arr[i],currCount+1);
          }
      }

      List<Integer> countVals = new ArrayList<>(counts.values());
      countVals.sort(Comparator.reverseOrder());

      List<Integer> topCounts = new ArrayList<>();
      for (int i=0;i<k;i++){
          topCounts.add(countVals.get(i));
      }

      List<Integer> topNums = new ArrayList<>();
      for (Map.Entry<Integer, Integer> e: counts.entrySet()){
          if (topCounts.contains(e.getValue())){topNums.add(e.getKey());}
      }
int[] result = topNums.stream().mapToInt(Integer::intValue).toArray();
      return result;
  }
}
