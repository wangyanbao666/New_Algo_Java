package org.example;

public class FindSmallestLetterGreaterThanTarget_744 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int l=0;
            int r=letters.length;
            while (l<r){
                int n = l + (r-l)/2;
                if ((n==0 || letters[n-1]<=target) && letters[n]>target){
                    return letters[n];
                }
                else if (letters[n]<=target){
                    l = n+1;
                }
                else {
                    r = n;
                }
            }
            return letters[0];
        }
    }
}
