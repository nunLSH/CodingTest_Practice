import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        // 각 종류 별 몇 개인지
        Map<String, Integer> map = new HashMap<>();
        for (String[] s : clothes)
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        
        int answer = 1;
        for (int j : map.values())
            answer *= (j+1);
        
        return answer - 1;
    }
}