import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long shortestTime = 1L;
        long longestTime = (long) times[times.length - 1] * n;
        
        long answer = longestTime;
        while (shortestTime <= longestTime){
            long sum = 0L;
            long mid = (shortestTime + longestTime) / 2;

            for (int i = 0; i < times.length; i++){
                sum += mid / times[i];
                if (sum >= n) break; 
            }
            
            if (sum < n){
                shortestTime = mid + 1;
            }
            else {
                answer = mid;
                longestTime = mid - 1;
            }
        }
        return answer;
    }
}
