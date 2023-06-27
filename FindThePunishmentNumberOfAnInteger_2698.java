package org.example;

public class FindThePunishmentNumberOfAnInteger_2698 {
    static class Solution {
        public int punishmentNumber(int n) {
            int result = 0;
            for (int i=1;i<=n;i++){
                int value = i*i;
                int valid = calcValid(i, String.valueOf(value));
                if (valid>0){
//                    System.out.println(i);
                    result+=value;
                }
            }
//            System.out.println(result);
            return result;
        }

        public int calcValid(int n, String s){
//            System.out.println(n);
            if (n<0){
                return 0;
            }
            if (!s.equals("")){
                if (Integer.parseInt(s)==n){
                    return 1;
                }
            }
            else {
                if (n==0){
                    return 1;
                }
            }

            for (int i=1;i<=s.length();i++){
                int a = Integer.parseInt(s.substring(0,i));
//                System.out.println("a: "+a);
//                System.out.println("n: "+n);

                int valid = calcValid(n-a,s.substring(i));
                if (valid>0){
                    return 1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.punishmentNumber(10);
    }
}
