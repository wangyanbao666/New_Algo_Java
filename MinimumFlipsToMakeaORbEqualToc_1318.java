package org.example;

public class MinimumFlipsToMakeaORbEqualToc_1318 {
    class Solution {
        public int minFlips(int a, int b, int c) {
            int result = 0;
            String aString = convert2Binary(a);
            String bString = convert2Binary(b);
            String cString = convert2Binary(c);
            int maxLength = Math.max(aString.length(), bString.length());
            maxLength = Math.max(maxLength, cString.length());
            aString = "0".repeat(maxLength-aString.length()) + aString;
            bString = "0".repeat(maxLength-bString.length()) + bString;
            cString = "0".repeat(maxLength-cString.length()) + cString;

            for (int i=0;i<maxLength;i++){
                if (aString.charAt(i)=='0' && bString.charAt(i)=='0' && cString.charAt(i)=='1'){
                    result += 1;
                }
                else if (aString.charAt(i)=='1' && bString.charAt(i)=='1' && cString.charAt(i)=='0'){
                    result += 2;
                }
                else if (aString.charAt(i)=='1' && bString.charAt(i)=='0' && cString.charAt(i)=='0'){
                    result += 1;
                }
                else if (aString.charAt(i)=='0' && bString.charAt(i)=='1' && cString.charAt(i)=='0'){
                    result += 1;
                }
            }
            return result;

        }

        public String convert2Binary(int a){
            StringBuilder binary = new StringBuilder();
            while (a>0){
                if (a%2==0){
                    binary.append("0");
                }
                else{
                    binary.append("1");
                }
                a/=2;
            }
            return binary.reverse().toString();
        }
    }
}
