package org.example;

public class MaximumValueataGivenIndexinaBoundedArray_1802 {
    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            return binarySearch(0, maxSum, index, n, maxSum);
        }

        public long left(int x, int index, int n){
            if (x>index){
                return (long) (x + x - index) *(index+1)/2;
            }
            return (long) (1 + x) *x/2+(index+1-x);
        }

        public long right(int x, int index, int n){
            if (x>=(n-index)){
                return (long) (x + x-(n - 1 - index)) *(n-index)/2;
            }
            return (long) (1 + x) *x/2+((n-index)-x);
        }

        public int binarySearch(int l, int r, int index, int n, int max){
            while (l<r){
                int m = Math.max(1,l+(r-l)/2);
                long value = left(m, index, n)+right(m, index, n)-m;

                if (value<max){
                    l = m+1;
                }
                else {
                    r = m;
                }
            }
            if (left(l, index, n)+right(l, index, n)-l<=max){
                return l;
            }
            return l-1;
        }
    }
}
