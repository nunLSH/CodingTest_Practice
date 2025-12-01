import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new ArrayDeque<>();
        PriorityQueue<Integer> maxPQ 
            = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int p : priorities){
            queue.offer(p);
            maxPQ.offer(p);
        }
        
        int answer = 0;
        while(!queue.isEmpty()){
            int cur = queue.peek();
            
            if (cur == maxPQ.peek()){
                answer++;
                queue.poll();
                maxPQ.poll();
                
                if (location == 0)
                    return answer;
                
                location--;
            } else{
                queue.poll();
                queue.offer(cur); 
                
                if (location == 0)
                    location = queue.size() - 1;
                
                else 
                    location--;
            }
        }
        return answer;
    }
}