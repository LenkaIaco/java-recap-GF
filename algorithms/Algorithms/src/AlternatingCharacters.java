public class AlternatingCharacters {
//    https://www.hackerrank.com/challenges/alternating-characters/problem
    /*
    You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.
    Your task is to find the minimum number of required deletions.
    Example s = AABAAA ;
    Remove an A at positions 0 and 3 to make s = ABAB in 2 deletions.
     */
    public static void main(String[] args){
       String s = "AABAAB";
        String s1 =  "AAAA";
        String s2 =   "BBBBB";
        String s3 =   "ABABABAB";
        String s4 = "BABABA";
        String s5 =   "AAABBB";

        System.out.println(minDeletionAmt(s)); //exp 2
        System.out.println(minDeletionAmt(s1)); // exp 3
        System.out.println(minDeletionAmt(s2));  //4
        System.out.println(minDeletionAmt(s3)); //0
        System.out.println(minDeletionAmt(s4)); //0
        System.out.println(minDeletionAmt(s5)); //4
    }


    public static int minDeletionAmt(String s){
    int minDeletions = 0;
    if (s.length()==1||s.length()==0){return minDeletions;}

    int sameCounter = 0;
    char same = (char)0;

    for (int i =0; i<s.length(); i++){
      if (i+1<s.length()) {
          if (s.charAt(i) == s.charAt(i + 1)) {
              minDeletions++;
          }
      }
    }

    return minDeletions;
    }
}
