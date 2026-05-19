import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 제곱수로 커지니까 최대한 서로 차이가 안 나는 것이 줄일 수 있는 방향
        // PQ 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());;
        for (int i : works)
            pq.offer(i);
        
        while (n-- > 0 && !pq.isEmpty()){
            int cur = pq.poll();
            
            cur--;
            if (cur == 0)
                continue;
            
            pq.offer(cur);
        }
        
        int len = pq.size();
        if (len > 0) {
            for (int i = 0; i < len; i++){
                answer += Math.pow(pq.poll(), 2);
            }
        }
            
        return answer;
    }
}