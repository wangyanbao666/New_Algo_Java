package org.example;

public class SwapNodes_1721 {


     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            int i=0;
            ListNode cur=head;
            ListNode first=head;
            ListNode last = head;
            boolean flag = false;
            while (cur != null){
                if (i>k-1){
                    last = last.next;
                }
                if (i==k-1){
                    first = cur;
                }
                i++;
                cur = cur.next;

            }
            int val = first.val;
            first.val = last.val;
            last.val = val;
            return head;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
    }
}
