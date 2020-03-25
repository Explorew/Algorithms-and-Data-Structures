package Leetcode.StackQuestions;

import java.util.ArrayList;

public class MinStack_155 {
    ArrayList arr;
    /** initialize your data structure here. */
    public MinStack_155() {
        arr = new ArrayList<Integer>();
    }

    public void push(int x) {
        arr.add(x);
    }

    public void pop() {
        arr.remove(arr.size()-1);
    }

    public int top() {
        return (int)(arr.get(arr.size()-1));
    }

    public int getMin() {
        int result = (int)arr.get(0);
        for(int i=1; i<arr.size(); i++){
            if(result > (int)arr.get(i))
                result = (int)arr.get(i);
        }
        return result;
    }
}
