import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int elen = elements.length;
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= elen; i++){ // 크기
            for (int j = 0; j < elen; j++){ // 시작 인덱스
                int sum = 0;
                int len = i, idx = j;
                while (len > 0){
                    sum += elements[idx];
                    
                    if (idx == elen -1)
                        idx = 0;
                    else idx++;
                    
                    len--;
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}