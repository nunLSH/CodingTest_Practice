import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for (String i : completion)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        for (String s : participant){
            if (!map.containsKey(s) || map.getOrDefault(s, 0) == 0){
                answer = s;
                break;
            }
            
            map.put(s, map.getOrDefault(s, 0) - 1);
        }
        
        return answer;
    }
}