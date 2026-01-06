import java.util.*;

class Solution {
    public int[] solution(String s) {

        String inner = s.substring(2, s.length() - 2);
        String[] sets = inner.split("\\},\\{");

        Arrays.sort(sets, Comparator.comparingInt(a -> a.split(",").length));

        int[] answer = new int[sets.length];
        int idx = 0;
        HashSet<Integer> seen = new HashSet<>();

        for (String ss : sets) {
            for (String p : ss.split(",")) {
                int num = Integer.parseInt(p);
                if (seen.add(num)) { 
                    answer[idx++] = num;
                    break;
                }
            }
        }
        return answer;
    }
}
