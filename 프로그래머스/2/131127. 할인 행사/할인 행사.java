import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++){ // 시작 인덱스
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i; j < i + 10; j++){ // 10일 연속
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }
            
            int cnt = 0;
            for (int k = 0; k < want.length; k++){
                if (map.containsKey(want[k])){
                    if (map.get(want[k]) == number[k])
                        cnt++;
                }
            }
            
            if (cnt == want.length)
                answer++;
        }
        
        return answer;
    }
}