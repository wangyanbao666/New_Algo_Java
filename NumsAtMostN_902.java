package org.example;

public class NumsAtMostN_902 {
    static class Solution {
        public int atMostNGivenDigitSet(String[] digits, int n) {
            return calculate(digits,n,true);

        }

        private int calculate(String[] digits, int n, boolean isOrigin){
            if (n==0){
                return 0;
            }
            int length = ((int)Math.log10(n))+1;
            System.out.println(n);
            System.out.println(length);
            int[] digitsInt = new int[digits.length];
            for (int i=0;i<digits.length;i++){
                digitsInt[i] = Integer.parseInt(digits[i]);
            }
            int digitLength = digits.length;
            int result = 0;

            if (isOrigin){
                for (int i=1;i<length;i++){
                    result += (int) Math.pow(digitLength,i);
                }
            }

//           get the starting digit
            int largePart = (int) Math.pow(10, length-1);
            int startingDigit = (int) n/largePart;

            for (int i=0;i<digits.length;i++){
                if (digitsInt[i]<startingDigit){
                    result += (int) Math.pow(digitLength,length-1);
                }
                //            if equal
                else if (digitsInt[i]==startingDigit) {
                    if (n<10){
                        if (digitsInt[i]<=n){
                            result += 1;
                        }
                        System.out.println("29line: "+result);
                    }
                    else if ((n - largePart*startingDigit)<=largePart/10) {
                        result += calculate(digits, n - largePart*startingDigit, false);
                        System.out.println("33line: "+result);
                    }
                }
            }
            return result;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.atMostNGivenDigitSet(new String[]{"1","4","9"},1000000000);
        System.out.println(result);
    }
}
