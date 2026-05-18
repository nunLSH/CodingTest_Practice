import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < operations.length; i++){
            String[] operation = operations[i].split(" ");
            String commend = operation[0];
            int num = Integer.parseInt(operation[1]);
            
            if (commend.equals("I")){
                map.put(num, num);
            } else {
                if (map.size() == 0)
                    continue;
                
                if (num == 1){
                    int max = map.lastKey();
                    map.remove(max);
                } else {
                    int min = map.firstKey();
                    map.remove(min);
                }
            }
        }
        
        if (map.size() != 0){
            return new int[]{map.lastKey(), map.firstKey()};
        }
        
        return new int[]{0, 0};
    }
}