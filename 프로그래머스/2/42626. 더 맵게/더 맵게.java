import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville)
            pq.offer(s);

        int count = 0;

        while (pq.size() > 1) {
            if (pq.peek() >= K)
                return count;

            int a = pq.poll();
            int b = pq.poll();

            pq.offer(a + b * 2);
            count++;
        }

        // 마지막 하나도 K 미만이면 실패
        return pq.peek() >= K ? count : -1;
    }
}
