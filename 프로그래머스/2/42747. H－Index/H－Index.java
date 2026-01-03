import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int len = citations.length;
        int answer = 0;
        
        for (int i = 0; i < len; i++) {
            int h = len - i;              // h 후보
            if (citations[i] >= h) {
                answer = h;               // 가능한 h 중 가장 큰 값
                break;                    // 뒤로 갈수록 h는 줄어드므로 바로 종료
            }
        }
        
        return answer;
    }
}
