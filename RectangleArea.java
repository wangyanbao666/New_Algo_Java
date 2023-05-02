public class RectangleArea {
    static class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int area1 = (ax2-ax1) * (ay2-ay1);
            int area2 = (bx2-bx1) * (by2-by1);
            int sum = area1 + area2;
            int x1;
            int x2;
            int y1;
            int y2;
            x1 = Math.max(ax1, bx1);
            x2 = Math.min(ax2, bx2);
            y1 = Math.max(ay1, by1);
            y2 = Math.min(ay2, by2);
            int overlap;
            if (x2<x1 || y2<y1){
                overlap = 0;
            }
            else {
                overlap = (x2-x1)*(y2-y1);
            }
            if (overlap > 0){
                sum -= overlap;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int area = s.computeArea(1,1,1,1,2,2,2,2);
        System.out.println(area);
    }
}
