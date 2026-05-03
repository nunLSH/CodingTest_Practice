import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 그리디
        // 주어진 스코빌 지수를 정렬
        // 우선순위큐 사용 >> 앞의 두 값을 뽑아서 새로운 값으로 만들어서 정렬
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville)
            pq.offer(i);
        
        while(pq.size() > 1){
            
            if(pq.peek() >= K)
                break;
            
            int fir = pq.poll();
            int sec = pq.poll();
            pq.offer(fir + sec * 2);
            answer++;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}