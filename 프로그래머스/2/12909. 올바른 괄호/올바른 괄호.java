import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        int i = 0;
        while(i < s.length()){
            
            if (s.charAt(i) == '(')
                stack.push('(');
            else 
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else if(stack.isEmpty()){
                    answer = false;
                    break;
                }
            
            i++;
        }
        
        if (!stack.isEmpty())
            return false;

        return answer;
    }
}