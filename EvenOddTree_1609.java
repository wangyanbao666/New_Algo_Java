package org.example;

import java.util.ArrayList;

public class EvenOddTree_1609 {
    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            ArrayList<TreeNode> left = new ArrayList<>();
            ArrayList<TreeNode> right = new ArrayList<>();
            int round = 0;
            left.add(root);
            while (left.size()>0 || right.size()>0){
                if (round==0){
                    int cur = 0;
                    while (left.size()>0){
                        TreeNode treeNode = left.remove(0);
                        if (treeNode.val%2==0 || treeNode.val<=cur) {
                            return false;
                        }
                        cur = treeNode.val;
                        if (treeNode.left != null){
                            right.add(treeNode.left);
                        }
                        if (treeNode.right != null){
                            right.add(treeNode.right);
                        }
                    }
                    round = 1;
                }
                else {
                    int cur = 1000001;
                    while (right.size()>0){
                        TreeNode treeNode = right.remove(0);
                        if (treeNode.val%2==1 || treeNode.val>=cur) {
                            return false;
                        }
                        cur = treeNode.val;
                        if (treeNode.left != null){
                            left.add(treeNode.left);
                        }
                        if (treeNode.right != null){
                            left.add(treeNode.right);
                        }
                    }
                    round = 0;
                }
            }
            return true;
        }
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

