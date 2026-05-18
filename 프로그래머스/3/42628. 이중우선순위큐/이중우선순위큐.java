import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String op : operations) {
            String[] operation = op.split(" ");
            String command = operation[0];
            int num = Integer.parseInt(operation[1]);
            
            if (command.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (map.isEmpty()) continue;
                
                int key = (num == 1) ? map.lastKey() : map.firstKey();
                
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }
        
        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{map.lastKey(), map.firstKey()};
    }
}