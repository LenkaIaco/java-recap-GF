package designGurus;

import java.util.*;

public class PalindromeQueue {
    /*
    Given a string s, determine if that string is a palindrome using a queue data structure.
        Return true if the string is a palindrome. Otherwise, return false.
        A palindrome is a word, number, phrase, or other sequence of characters that reads the same forward and
        backward, ignoring spaces, punctuation, and capitalization.

        Input: s = "madam"
        Output: true
        Input: s = "openai"
        Output: false
        Input: s = "A man a plan a canal Panama"
        Output: true
     */


    public static void main(String[] args) {
        System.out.println(isPalindromeStack("aba"));//exp.out.:true
        System.out.println(isPalindromeStack("openai"));//exp.out.: false
        System.out.println(isPalindromeStack("A man a plan a canal Panama"));//exp.out.: true

        System.out.println(isPalindromeDeque("aba"));//exp.out.:true
        System.out.println(isPalindromeDeque("openai"));//exp.out.: false
        System.out.println(isPalindromeDeque("A man a plan a canal Panama"));//exp.out.: true
    }

    public static boolean isPalindromeDeque(String s){
     s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
     Deque<Character> deque = new LinkedList<>();

     for (int i=0;i<s.length();i++){
         deque.add(s.charAt(i));
     }

     while(deque.size()>1){
         if (deque.pollFirst()!=deque.pollLast()){
             return false;
         }
     }
     return true;
    }

    public static boolean isPalindromeStack(String s){
        s = s.replaceAll("[^a-zA-Z0-9]","");
        s = s.toLowerCase();

        Stack<Character> verifyHalf = new Stack<>();
       for (int i=0;i<s.length();i++){
           if (i < s.length()/2) {
               verifyHalf.push(s.charAt(i));
           }else if(i==s.length()/2){
               if (s.length()%2==0){
                   if(!verifyHalf.pop().equals(s.charAt(i))){
                       return false;
                   }
               }
           }
           else {  //(i>s.length()/2)
               if (!verifyHalf.pop().equals(s.charAt(i))){
                   return false;
               }
           }
       }

       return true;
    }
}
