package org.example;

public class New21Game_837 {
    class Solution {
        public double new21Game(int n, int k, int maxPts) {
            if (k==0 || n>=k+maxPts-1){
                return 1.0;
            }
            int w = maxPts;
            double res = 0;
            double wSum = 1;
            double[] dp = new double[n+1];
            dp[0] = 1;
            for (int i=1;i<k;i++){
                dp[i] = wSum/w;
                wSum += dp[i];
                if (i>=w){
                    wSum -= dp[i-w];
                }
            }
            double a;
            for (int i=k;i<=n;i++){
                a = wSum/w;
                res += a;
                dp[i] = a;
                if (i>=w){
                    wSum -= dp[i-w];
                    if (wSum == 0){
                        break;
                    }
                }
            }
            return res;
        }
    }
}
