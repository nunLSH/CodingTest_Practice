import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (map.isEmpty()) continue;

                int key;
                if (num == 1) {
                    key = map.lastKey();   // 최댓값 삭제
                } else {
                    key = map.firstKey();  // 최솟값 삭제
                }

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