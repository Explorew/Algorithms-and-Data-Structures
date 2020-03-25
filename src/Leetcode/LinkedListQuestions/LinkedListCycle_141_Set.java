package Leetcode.LinkedListQuestions;
import java.util.HashSet;
import java.util.Set;


public class LinkedListCycle_141_Set {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null){
            if(set.contains(head))
                return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}