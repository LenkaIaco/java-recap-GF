package leetcodeTop150.ArrayString;

import java.util.HashMap;
import java.util.Map;

public class OIntegerToRoman {

    public static void main(String[] args) {

        int n0 =3749;
        int n1 =58;
        int n2 =1994;
        System.out.println(intToRoman(n0)); //MMMDCCXLIX
        System.out.println(intToRoman(n1)); // LVIII
        System.out.println(intToRoman(n2)); // MCMXCIV
    }

    public static String intToRoman(int num) {
        char[] roman = {'M','D','C','L','X','V','I'};
        int[] arabic = {1000,500,100,50,10,5,1};

        int remainder = num;

        StringBuilder sb = new StringBuilder();

        for (int i = 0;i< roman.length;i+=2){
            int division = remainder / arabic[i];
            if (division>0){
                if (division==9){
                    sb.append(roman[i]);
                    sb.append(roman[i-2]);
                }
                else if (division>=5){
                    sb.append(roman[i-1]);
                    int loops  = (remainder-arabic[i-1]) / arabic[i];
                    for (int y=0;y<loops;y++) {
                        sb.append(roman[i]);
                    }
                }
                else if(division==4) {
                    sb.append(roman[i]);
                    sb.append(roman[i-1]);
                }
                else{
                    for (int y=0;y<division;y++){
                        sb.append(roman[i]);
                    }
                }
            }
            remainder = remainder % arabic[i];
        }
        return sb.toString();
    }
}
