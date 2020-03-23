package Leetcode.StackQuestions;

import java.util.Stack;

public class MaximalRectangle_85_Stack {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int max = 0;
        int row[] = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                row[j] = matrix[i][j]=='1'? row[j]+1 : 0;
            }
            max = Math.max(max, MaxHistHistogram(row));
        }
        return max;
    }

    public static int MaxHistHistogram(int histogram[]){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int counter = 0;
        while(counter < histogram.length){
            if(stack.isEmpty() || histogram[stack.peek()] <= histogram[counter]){
                stack.push(counter);
                counter++;
            }
            else{
                int currBar = stack.pop();
                int currMax = histogram[currBar] * (stack.isEmpty()? counter : counter - stack.peek() - 1);
                max = Math.max(max, currMax);
            }
        }
        while(!stack.isEmpty()){
            int currBar = stack.pop();
            int currMax = histogram[currBar] * (stack.isEmpty()? counter : counter - stack.peek() - 1);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
