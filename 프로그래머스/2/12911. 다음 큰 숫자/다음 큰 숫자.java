import java.util.*;
class Solution {
    public static final int MAX = 1000000;
    
    public int binaryNum(int num){
        int cnt = 0;
        while (num > 0){
            if (num % 2 == 1) cnt++;
            num /= 2;
        }
        
        return cnt;
    }
    
    public int solution(int n) {
        int answer = 0;
        for (int i = n+1; i < MAX+1; i++){
            if (binaryNum(i) == binaryNum(n)){
                answer = i;
                break;
            }
        }
    
        return answer;
    }
}