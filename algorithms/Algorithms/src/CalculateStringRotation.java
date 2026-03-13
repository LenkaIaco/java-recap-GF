public class CalculateStringRotation {
    // https://www.codewars.com/kata/5596f6e9529e9ab6fb000014
    /*
Write a function that receives two strings and returns the number of characters we should shift
in the first string forward, to match the second. The check should be case sensitive.

If the second string isn't a valid rotation of the first string, the method returns -1.
Examples:
"coffee", "eecoff" => 2
"eecoff", "coffee" => 4
"moose", "Moose" => -1
"isn't", "'tisn" => 2
"Esham", "Esham" => 0
"dog", "god" => -1
     */
    public static void main(String[] args) {
String s1 = "coffee";
String s2 = "eecoff";
System.out.println(rotationAmount(s1, s2)); // exp.: 2
 s1 =  "eecoff";
 s2 =  "coffee";
 System.out.println(rotationAmount(s1, s2)); // exp.: 4
s1 =  "moose";
s2 =  "Moose";
 System.out.println(rotationAmount(s1, s2)); // exp.: -1
s1 =  "isn't";
s2 =  "'tisn";
 System.out.println(rotationAmount(s1, s2)); // exp.: 2

s1 = "Esham";
s2 = "Esham";
 System.out.println(rotationAmount(s1, s2)); // exp.: 0

s1 = "dog";
s2 = "god";
 System.out.println(rotationAmount(s1, s2)); // exp.: -1

    }

    public static int rotationAmount(String s1, String s2){
        int result = -1;

        if (s1==null||s2==null){return result;}
        if (s1.isEmpty()||s2.isEmpty()){return result;}
        if (s1.length()!=s2.length()){return result;}
        char[] arr1 = s1.toCharArray();

        result = 0;
        if (s1.equals(s2)){return result;}

        for (int i=0;i<s1.length()-1;i++){
            char c = arr1[s1.length()-1];
            arr1[0] = c;
            for (int y=1;y<s1.length();y++){
                arr1[y] = s1.charAt(y-1);
            }
            result++;
            s1 = String.valueOf(arr1);
            if (s1.equals(s2)){return result;}
        }

        result = -1;

        return result;
    }
}
