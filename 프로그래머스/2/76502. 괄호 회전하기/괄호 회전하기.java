import java.util.*;
class Solution {
    public int answer;
    
    public boolean isRight(String s){
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            
            if (sc == '(' || sc == '{' || sc == '[')
                stack.push(sc);
            else { // 닫는 괄호
                if (stack.isEmpty())
                    return false;
                
                char c = stack.peek();

                if ((c == '(' && sc == ')')
                   || (c == '{' && sc == '}')
                   || (c == '[' && sc == ']'))
                    stack.pop(); 
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
    
    public int solution(String s) {
        answer = 0;
        int len = s.length();
        
        for (int i = 0; i < len; i++){
            String str = s.substring(i) + s.substring(0, i);
            
            if (isRight(str))
                answer++;
        }
        
        return answer;
    }
}