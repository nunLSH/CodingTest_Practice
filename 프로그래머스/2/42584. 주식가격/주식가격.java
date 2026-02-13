import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> s = new ArrayDeque<>();
        s.push(0);
        
        for (int i = 1; i < prices.length; i++){
            
            while(!s.isEmpty() && prices[s.peek()] > prices[i]){
                int pre = s.peek();
                answer[pre] = i - pre;
                s.pop();
            }
            
            s.push(i);
        }
        
        while (!s.isEmpty()){
            int idx = s.pop();
            answer[idx] = prices.length - 1 - idx;
        }
    
        return answer;
    }
}