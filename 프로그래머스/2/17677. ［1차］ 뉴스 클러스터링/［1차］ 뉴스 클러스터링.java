import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 각각의 다중집합 >> Map 사용
        Map<String, Integer> map1 = makeMultiSet(str1);
        Map<String, Integer> map2 = makeMultiSet(str2);
        
        // 합집합, 교집합
        double union = 0;
        double intersection = 0;
        
        for (String key : map1.keySet()) {
            int cnt1 = map1.get(key);
            int cnt2 = map2.getOrDefault(key, 0);

            intersection += Math.min(cnt1, cnt2);
            union += Math.max(cnt1, cnt2);
        }
        
        for (String key : map2.keySet()) {
            if(!map1.containsKey(key))
                union += map2.get(key);
        }
        
        System.out.println(union + " " + intersection);
        
        if (union == 0) return 65536;
        
        return (int)(intersection / union * 65536);

    }
    
    public Map<String, Integer> makeMultiSet(String str){
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i + 2);

            if (isAlphabetic(s)) {
                s = s.toUpperCase();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        return map;
    }
    
    public boolean isAlphabetic(String s){
        for (int i = 0; i < 2; i++)
            if (!Character.isAlphabetic(s.charAt(i)))
                return false;
        
        return true;
    }
}