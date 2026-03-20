package gf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhichAreIn {

    /*
    Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.

Example 1:
a1 = ["arp", "live", "strong"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns ["arp", "live", "strong"]

Example 2:
a1 = ["tarp", "mice", "bull"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns []
     */

    public static void main(String[] args) {
String[] arr1 = {"arp", "live", "strong"};
String[] arr2 = {"lively", "alive", "harp", "armstrong"};

String[]arr3 = {"tarp", "mice", "bull"};
String[]arr4 = {"lively", "alive", "harp", "sharp", "armstrong"};

//exp. output ["arp", "live", "strong"]
        System.out.println(Arrays.toString(substringAlphabetical(arr1,arr2)));
// ex. out. []
        System.out.println(Arrays.toString(substringAlphabetical(arr3,arr4)));

    }

    public static String[] substringAlphabetical(String[] arr1, String[] arr2){
        if (arr1==null||arr2==null){return null;}
        if (arr1.length==0||arr2.length==0){return new String[0];}
        List<String> l = new ArrayList<>();

        for (int i = 0; i<arr1.length; i++){
            for (int y=0;y<arr2.length;y++){
                String s1 = arr1[i];
                String s2 = arr2[y];
                boolean flag = false;
                if (s2.length()>s1.length()){
                    for (int z=0;z<=s2.length()-s1.length();z++){
                        if (s1.equals(
                                s2.substring(z,z+s1.length())
                        )){
                            l.add(s1);
                            flag = true;
                            break;
                        }

                    }
                }
                if (flag){break;}
            }
        }
        if (!l.isEmpty()) {
           l =  l.stream().sorted().toList();
        }
        return l.toArray(new String[l.size()]);
    }
}
