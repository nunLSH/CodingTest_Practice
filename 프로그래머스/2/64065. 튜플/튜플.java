import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        // 각 부분집합 분리
        String inner = s.substring(2, s.length() - 2);
        String[] sets = inner.split("\\},\\{");
        
        // 원소 개수가 적은 순
        Arrays.sort(sets, (a, b) -> {
            return a.split(",").length - b.split(",").length;
        });

        // 길이가 증가될 수록 이전에 없던 숫자 추가
        int[] answer = new int[sets.length];
        int idx = 0;
        HashSet<String> set = new HashSet<>();
        for (String ss : sets){
            String[] parts = ss.split(",");
            
            for (String p : parts){
                if (!set.contains(p)){
                    answer[idx++] = Integer.parseInt(p);
                    set.add(p);
                }
            }

        }
        
        return answer;
    }
}