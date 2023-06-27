package org.example;

public class NumberOfSenior_6366 {
    static class Solution {
        public int countSeniors(String[] details) {
            int result = 0;
            for (int i=0;i<details.length;i++){
                int age = Integer.parseInt(details[i].substring(11,13));
                if (age>60){
                    result++;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"}));
    }
}
