import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int len = people.length;
        Arrays.sort(people);
        
        int answer = 0;
        int sIdx = 0;
        int eIdx = len - 1;
        while (len > 0 && sIdx < eIdx){
            if (people[sIdx] + people[eIdx] <= limit){
                sIdx++; eIdx--; answer++; len -= 2;
                if (sIdx == eIdx){
                    answer++;
                    len--;
                    break;
                }
            } else {
                answer++; eIdx--; len--;
                if (sIdx == eIdx){
                    answer++;
                    len--;
                    break;
                }
            }
        }
        
        return answer;
    }
}