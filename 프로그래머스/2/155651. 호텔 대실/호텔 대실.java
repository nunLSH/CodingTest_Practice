import java.util.*;
import java.time.LocalTime;

class Solution {
    public int solution(String[][] book_time) {

        // 정렬
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        PriorityQueue<LocalTime> pq = new PriorityQueue<>();
        pq.offer(LocalTime.parse(book_time[0][1]));
        
        // 비교
        for (int i = 1; i < book_time.length; i++) {
            LocalTime start = LocalTime.parse(book_time[i][0]);
            LocalTime end   = LocalTime.parse(book_time[i][1]);

            LocalTime earliestEnd = pq.peek().plusMinutes(10);

            if (!earliestEnd.isAfter(start)) 
                pq.poll();

            pq.offer(end);
        }
        
        return pq.size();
    }
}