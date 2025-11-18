import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        char[] answer = new char[number.length() - k];
        
        for (int i = 0; i < number.length(); i++){
            char cur = number.charAt(i);
            
            while (!stack.isEmpty() && stack.peek() < cur && k > 0){
                stack.pop();
                k--;
            }
            
            stack.push(cur);
        }
        
        for (int i = 0; i < answer.length; i++)
            answer[i] = stack.get(i);
        
        return new String(answer);
    }
}