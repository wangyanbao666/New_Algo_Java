package org.example;

public class MinimumAbsoluteDifferenceInBST_530 {
    class Solution {
        public int getMinimumDifference(TreeNode root) {
            int[] result = new int[]{Integer.MAX_VALUE};
            int[] temp = new int[]{0};
            inOrder(root, result, temp);
            return result[0];
        }
        public void inOrder(TreeNode root, int[] result, int[] temp){
            if (root.left != null){
                inOrder(root.left, result, temp);
            }
            int r = Math.abs(temp[0]-root.val);
            temp[0] = root.val;
            if (r<result[0]){
                result[0] = r;
            }
            if (root.right != null){
                inOrder(root.right, result, temp);
            }
        }
    }
}
