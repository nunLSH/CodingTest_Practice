import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for (String[] wear : clothes){
            map.put(wear[1], map.getOrDefault(wear[1], 0) + 1);
        }
        
        for (String s : map.keySet()){
            int num = map.get(s);
            answer *= (num + 1);
        }
        
        return answer - 1;
    }
}