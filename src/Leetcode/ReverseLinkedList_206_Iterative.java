package Leetcode;

public class ReverseLinkedList_206_Iterative {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode pre = null;
        ListNode curr = null;
        ListNode next = head;
        while(next != null){
            pre = curr;
            curr = next;
            next = curr.next;
            curr.next = pre;
        }
        return curr;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
