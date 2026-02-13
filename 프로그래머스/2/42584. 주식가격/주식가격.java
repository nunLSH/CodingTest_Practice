import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{prices[0], 0});
        
        for (int i = 1; i < prices.length; i++){
            
            while(!s.isEmpty() && s.peek()[0] > prices[i]){
                int[] pre = s.peek();
                answer[pre[1]] = i - pre[1];
                s.pop();
            }
            
            s.push(new int[]{prices[i], i});
        }
        
        while (!s.isEmpty()){
            int[] cur = s.pop();
            answer[cur[1]] = prices.length - 1 - cur[1];
        }
    
        return answer;
    }
}