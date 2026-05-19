import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        while (n-- > 0 && !pq.isEmpty()) {
            int cur = pq.poll();

            if (cur == 0) break;

            pq.offer(cur - 1);
        }

        while (!pq.isEmpty()) {
            long work = pq.poll();
            answer += work * work;
        }

        return answer;
    }
}