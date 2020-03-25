package Leetcode.StackQuestions;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeInLinkedList_1019 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] nextLargerNodes(ListNode head) {
        if(head == null)
            return null;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        int result[] = new int[arr.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.size()-1; i>=0; i--){
            if(stack.isEmpty()){
                stack.push(arr.get(i));
                result[i]=0;
            }
            else if( arr.get(i) >= stack.peek()){
                while(!stack.isEmpty() && arr.get(i) >= stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(arr.get(i));
                    result[i]=0;
                }
                else if(arr.get(i) < stack.peek()){
                    result[i]=stack.peek();
                    stack.push(arr.get(i));
                }
            }
            else{
                result[i] = stack.peek();
                stack.push(arr.get(i));
            }

        }
        return result;
    }
}
