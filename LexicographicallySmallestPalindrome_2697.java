package org.example;

public class LexicographicallySmallestPalindrome_2697 {
    class Solution {
        public String makeSmallestPalindrome(String s) {
            for (int i=0;i<s.length()/2;i++){
                if (s.charAt(i) > s.charAt(s.length()-i-1)){
                    s = s.substring(0,i)+s.charAt(s.length()-i-1)+s.substring(i+1);
                }
                else {
                    s = s.substring(0,s.length()-i-1)+s.charAt(i)+s.substring(s.length()-i);
                }
            }
            return s;
        }
    }
}
