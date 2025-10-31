import java.util.*;
class Solution {
    public int solution(int[] array) {
        int maxCnt = 0;
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array){
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
            
            if (maxCnt < cnt){
                maxCnt = cnt;
                answer = num;
            } else if (maxCnt == cnt)
                answer = -1;
            else
                continue;
        }
        
        return answer;
        
    }
}