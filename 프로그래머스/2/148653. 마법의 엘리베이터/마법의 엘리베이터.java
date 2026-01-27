import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int cur = storey % 10;
            int next = (storey / 10) % 10;
            
            if (cur > 5){
                answer += (10 - cur);
                storey = storey / 10 + 1;
            } else if (cur < 5) {
                answer += cur;
                storey /= 10;
            } else {
                if (next >= 5) {
                    answer += 5;
                    storey = storey / 10 + 1;
                } else {
                    answer += 5;
                    storey /= 10;
                }
            }
        }
        
        return answer;
    }
}