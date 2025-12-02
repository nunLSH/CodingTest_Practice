import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i: scoville)
            pq.offer(i);
        
        int answer = 0;
        while (!pq.isEmpty()){
            if (pq.peek() >= K)
                break;
            
            int s1 = pq.poll();
            
            if (pq.isEmpty()){
                answer = -1;
                break;
            }
            
            int s2 = pq.poll();
            
            pq.offer(s1 + (s2 * 2));
            answer++;
        }
        return answer;
    }
}