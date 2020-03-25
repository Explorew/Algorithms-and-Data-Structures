package Leetcode.StackQuestions;

import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean result = true;
        if(s.length()%2 != 0)
            result = false;
        for(int i=0; i<s.length() ; i++){
            if(s.charAt(i) != ')' && s.charAt(i) != '}' && s.charAt(i) != ']'){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')' ){
                if(stack.empty() || stack.pop() != '(')
                    result = false;
            }
            if(s.charAt(i) == '}' ){
                if(stack.empty() || stack.pop() != '{')
                    result = false;
            }
            if(s.charAt(i) == ']' ){
                if(stack.empty() || stack.pop() != '[')
                    result = false;
            }
        }
        if(!stack.empty())
            result = false;
        return result;


    }
}
