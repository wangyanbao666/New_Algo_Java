import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesII {
    static class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            Map<Integer, HashMap> m = new HashMap<Integer, HashMap>();
            int res = 0;
            for (int i=0; i<nums.length; i++) {
                m.put(i, new HashMap<Long, Integer>());
                for (int j = 0; j < i; j++) {
                    long absDiff = (long) nums[i] - (long) nums[j];
                    int prev = (int) (m.get(j).getOrDefault(absDiff, 0));
                    int cur = (int) (m.get(i).getOrDefault(absDiff, 0));
                    m.get(i).put(absDiff, cur+prev+1);
                    res += (int) prev;
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.numberOfArithmeticSlices(new int[]{2,6,4,10});
        System.out.println(res);
    }
}
