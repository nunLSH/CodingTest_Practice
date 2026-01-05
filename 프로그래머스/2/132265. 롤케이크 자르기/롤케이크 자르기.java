import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : topping)
            map.put(t, map.getOrDefault(t, 0) + 1);
        
        int bro = map.size();
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < topping.length - 1; i++){
            set.add(topping[i]);
            map.put(topping[i], map.getOrDefault(topping[i], 0) - 1);
            
            if (map.get(topping[i]) == 0)
                bro--;
            
            if (set.size() == bro)
                answer++;
        }
        
        return answer;
    }
}