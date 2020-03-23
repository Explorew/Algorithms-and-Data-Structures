package Leetcode.StackQuestions;

import java.util.Stack;

public class LargestRectangleinHistogram_84_Stack {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int counter = 0;
        while(counter < heights.length){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[counter]){
                stack.push(counter);
                counter++;
            }
            else{
                int currBar = stack.pop();
                max = Math.max(max, heights[currBar]*(stack.isEmpty()?counter: counter-stack.peek()-1));
            }
        }
        while(!stack.isEmpty()){
            int currBar = stack.pop();
            max = Math.max(max, heights[currBar]*(stack.isEmpty()?counter: counter-stack.peek()-1));
        }
        return max;
    }
}
