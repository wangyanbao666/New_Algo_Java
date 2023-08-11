package org.example;

public class MinimumStringLength_2696 {
    static class Solution {
        public int minLength(String s) {
            boolean flag;
            while (true) {
                flag = false;
                for (int i=0;i<s.length()-1;i++){
                    if (s.startsWith("AB", i) || s.startsWith("CD", i)){
                        s = s.substring(0,i)+s.substring(i+2);
                        flag = true;
                    }
                }
                if (!flag){
                    return s.length();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
