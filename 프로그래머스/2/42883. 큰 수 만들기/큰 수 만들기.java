import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);

            while (!stack.isEmpty() && stack.peek() < cur && k > 0) {
                stack.pop();  
                k--;
            }

            stack.push(cur); 
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }
}