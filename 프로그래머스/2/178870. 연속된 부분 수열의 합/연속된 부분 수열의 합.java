
import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0; // 끝
        int bestS = 0, bestE = 0, bestLen = Integer.MAX_VALUE;
        int sum = sequence[0];
        while (end < sequence.length){
            if (sum < k){
                end++;
                if (end < sequence.length)
                    sum += sequence[end];
            } else if (sum > k){
                sum -= sequence[start];
                start++;
            } else {
                if (end - start < bestLen){
                    bestLen = end - start;
                    bestS = start;
                    bestE = end;
                }
                sum -= sequence[start];
                start++;
            }
        }
        
        return new int[]{bestS, bestE};
    }
}