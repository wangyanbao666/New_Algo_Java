import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {
    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int n = Math.floorDiv(nums.length, 3);
            int n1 = 0;
            int n2 = 0;
            int cur1 = -1000000000;
            int cur2 = -1000000000;
            List<Integer> result = new ArrayList<>();
            for (int i: nums) {
                if (i == cur1){
                    n1++;
                }
                else if (i == cur2){
                    n2++;
                }
                else if (n1 == 0){
                    cur1 = i;
                    n1++;
                }
                else if (n2 == 0){
                    cur2 = i;
                    n2++;
                }
                else{
                    n2--;
                    n1--;
                }
            }
            n1 = 0;
            n2 = 0;

            for (int i: nums){
                if (i == cur1){
                    n1++;
                }
                else if (i == cur2){
                    n2++;
                }
            }
            if (n1 > n){
                result.add(cur1);
            }
            if (n2 > n){
                if (!result.contains(cur2)){
                    result.add(cur2);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List res = s.majorityElement(new int[]{2,1,1,3,1,4,5,6});
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
