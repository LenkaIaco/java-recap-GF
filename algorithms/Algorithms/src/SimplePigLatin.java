public class SimplePigLatin {
    //https://www.codewars.com/kata/520b9d2ad5c005041100000f/
    /*
    Move the first letter of each word to the end of it, then add "ay" to the end of the word.
    Leave punctuation marks untouched.
Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !

     */
    public static void main(String[] args) {
        System.out.println(pigIt("Hello world!"));
        System.out.println(pigIt("Hello world !"));
        System.out.println(pigIt("Pig latin is cool"));
        System.out.println(pigIt("\"Hello world!!!"));
    }

    public static String pigIt(String s){
        String punctuation = ",./;:'\"[]{}=-_`~!@#$%^&*()";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
      if (s==null){return null;}
      if(s.length()==0){return s;}
        String[] arr = s.split(" ");
      boolean flagFirst = false;
      boolean flagSecond = false;
        for (int i=0;i< arr.length;i++){ // all words
            flagFirst =false;
            flagSecond = false;
            for (int y=0; y<arr[i].length();y++){//within one word
                char firstCurrent = arr[i].charAt(y);
                if (alphabet.contains(String.valueOf(firstCurrent))){
                    flagFirst = true;
                   for (int z = arr[i].length()-1; z>y; z--){
                       char lastCurrent = arr[i].charAt(z);
                       if (!punctuation.contains(String.valueOf(lastCurrent))){
                           flagSecond = true;
                           //shuffle
                              String sNew =  arr[i].substring(0,y) + arr[i].substring(y+1,z+1) + arr[i].charAt(y) + "ay";
                              arr[i]=sNew;
                           break;
                       }
                   }
                }
                if (flagFirst){
                    if (!flagSecond){
                        //shuffle
                        String sNew = arr[i].substring(0,y) + arr[i].substring(y+1,arr[i].length()) + arr[i].charAt(y) + "ay";
                    }
                    break;
                }
            }
        }
        String result = "";
        for (int i = 0; i<arr.length;i++){
            if (i==0){
                result = arr[i];
            } else{
            result = result + " " + arr[i];
            }
        }
        return result;
    }
}

