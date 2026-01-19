import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        // k 진수로 변환
        String num = toBaseN(n, k);
        
        // 해당하는 소수가 있는지 검사
        int answer = 0;
        String[] nums = num.split("0+");
        
        for (String s : nums){
            if(isPrime(Long.parseLong(s)))
                answer++;
        }
        
        return answer;
    }
    
    // k진수 변환 함수
    public static String toBaseN(int num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    // 소수인지 확인
    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

}