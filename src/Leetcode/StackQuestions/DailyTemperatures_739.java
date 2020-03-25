package Leetcode.StackQuestions;

import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<>();
        int arr[] = new int[T.length];
        for(int i=T.length-1; i>=0; i--){
            while(!stack.isEmpty() && T[i] >= stack.peek()[0] )
                stack.pop();
            if(stack.isEmpty())
                arr[i] = 0;
            else
                arr[i] = stack.peek()[1] - i;
            int temp[] = {T[i], i};
            stack.push(temp);
        }
        return arr;
    }
}
