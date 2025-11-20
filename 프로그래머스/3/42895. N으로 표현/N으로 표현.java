import java.util.*;
class Solution {
    public int solution(int N, int number) {
 
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++)
            dp.add(new HashSet<>());
        
        for (int i = 1; i <= 8; i++){
            dp.get(i).add(concat(N, i)); // N 이어붙이기
            
            for (int j = 1; j < i; j++){
                for (int n : dp.get(j)){
                    for (int m : dp.get(i-j)){
                        dp.get(i).add(n + m);
                        dp.get(i).add(n - m);
                        dp.get(i).add(n * m);
                        if (m != 0)
                            dp.get(i).add(n / m);
                    }
                }
            }
            
            if (dp.get(i).contains(number))
                return i;
        }
        
        return -1;
    }
    
    public int concat(int N, int cnt){
        int sum = 0;
        
        for (int i = 0; i < cnt; i++)
            sum = sum * 10 + N;
        
        return sum;
    }
}