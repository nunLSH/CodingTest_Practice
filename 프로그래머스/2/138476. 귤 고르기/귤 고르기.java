import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {        
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : tangerine) 
            count.put(num, count.getOrDefault(num, 0) +1);
        
        List<Integer> freq = new ArrayList<>(count.values());
        freq.sort(Collections.reverseOrder());
        
        int answer = 0;
        int sum = 0;
        for (int c : freq){
            sum += c;
            answer++;
            if (sum >= k) break;
        }
        
        return answer;
    }
}