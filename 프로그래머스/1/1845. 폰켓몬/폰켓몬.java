import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> pocketmon = new HashSet<>();
        
        for (int i : nums)
            pocketmon.add(i);
        
        answer = Math.min(pocketmon.size(), nums.length / 2);
        return answer;
    }
}