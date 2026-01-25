class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int n = 1; n <= number; n++){
            // 제한 수치를 넘는 공격력
            if (countDivisors(n) > limit)
                answer += power;
            else 
                answer += countDivisors(n);
        }
        
        return answer;
    }
    
    // 약수의 개수 구하기
    public int countDivisors(int num){
        int cnt = 0;
        
        for (int i = 1; i * i <= num; i++){
            if(num % i == 0){
                cnt++;
                if (i != num / i)
                    cnt++;
            }
        }
        
        return cnt;
    }
}