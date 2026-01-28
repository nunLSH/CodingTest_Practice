import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Long> count = new HashMap<>();
        for (int w : weights) {
            count.put(w, count.getOrDefault(w, 0L) + 1);
        }
        
        long answer = 0;
        
        // 같은 몸무게끼리 조합 (nC2)
        for (long c : count.values()) {
            if (c > 1) {
                answer += c * (c - 1) / 2;
            }
        }
        
        // 가능한 비율 관계
        int[][] ratios = {
            {2, 3},
            {2, 4},
            {3, 4}
        };
        
        for (int w : count.keySet()) {
            long cw = count.get(w);
            for (int[] r : ratios) {
                int a = r[0], b = r[1];
                
                // w * a / b 가 정수인지 체크
                if (w * a % b == 0) {
                    int target = w * a / b;
                    if (count.containsKey(target)) {
                        answer += cw * count.get(target);
                    }
                }
            }
        }
        
        return answer;
    }
}
