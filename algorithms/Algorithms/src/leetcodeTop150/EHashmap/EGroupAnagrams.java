package leetcodeTop150.EHashmap;

import java.util.*;

public class EGroupAnagrams {
    /*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Input: strs = [""]
Output: [[""]]

Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
     */
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs1 = {""};
        String[] strs2 = {"a"};
        System.out.println(groupAnagrams2(strs));//[["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams2(strs1));// {{""}}
        System.out.println(groupAnagrams2(strs2));//{{"a"}}
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        int[] indices = new int[strs.length];
        groups.put(strs[0], new ArrayList<>(Arrays.asList(strs[0])));
        for (int i = 0; i < strs.length; i++) {
             if (i!=0&&indices[i] != 0) {
                groups.put(strs[i], new ArrayList<>(Arrays.asList(strs[i])));
             }

                for (int y = i + 1; y < strs.length; y++) {
                    if (i==0) {
                            if (DValidAnagram.isAnagram(strs[i],strs[y])) {
                                List<String> anagrams = groups.get(strs[i]);
                                anagrams.add(strs[y]);
                            } else {
                                indices[y] = y;
                            }

                    }
                    else {
                      if (indices[i]!=0&&indices[y] != 0){
                          String ith = strs[i];
                          String yth = strs[y];
                          if (DValidAnagram.isAnagram(strs[i],strs[y])) {
                              List<String> anagrams = groups.get(strs[i]);
                              anagrams.add(strs[y]);
                              indices[y]=0;
                          }
                      }
                    }
                }
            }

        List<List<String>> result = new ArrayList<>();

        for (List<String> l : groups.values()){
            result.add(l);
        }
        return result;
    }


    public static List<List<String>> groupAnagrams2(String[] strs) {
        String[] arr2 = Arrays.copyOf(strs,strs.length);
        List<Integer> groups = new ArrayList<>();
        int lastI = -1;
        for (int i=0;i<arr2.length;i++){
            if (i>lastI) {
                for (int y = lastI + 1; y < arr2.length; y++) {
                    if (DValidAnagram.isAnagram(arr2[i], arr2[y])) {
                            String cut = arr2[lastI + 1];
                            arr2[lastI + 1] = arr2[y];
                            arr2[y] = cut;
                            lastI++;
                    }
                    if (y == arr2.length - 1) {
                        lastI = Math.max(i,lastI);
                        groups.add(lastI);
                    }
                }
            }
        }
        int start = 0;
        List<List<String>> result = new ArrayList<>();
        for (Integer intg:groups){
            List<String> l = new ArrayList<>();
            for (int i=start;i<intg+1;i++){
                l.add(arr2[i]);
            }
            result.add(l);
            start = intg+1;
        }
        return result;
    }
    }
