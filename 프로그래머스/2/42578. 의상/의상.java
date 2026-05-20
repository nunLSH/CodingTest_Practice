import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for (String[] wear : clothes){
            map.put(wear[1], map.getOrDefault(wear[1], 0) + 1);
        }
        
        // 각 카테고리별 착장 0개 선택 or 1개 선택
        for (int j : map.values()){
            answer *= (j + 1); // 1개 선택: j, 0개 선택: 1
        }
        
        return answer - 1; // 아무것도 선택하지 않는 경우 제외
    }
}