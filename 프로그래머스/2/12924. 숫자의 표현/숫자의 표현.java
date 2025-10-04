class Solution {
    public boolean natural(int cnt, int n){
        int sum = 0;
        for (int i = 0; i < cnt; i++){
            sum += i;   
            
            if (sum >= n)
                return false;
        }
        
        if ((n - sum) % cnt == 0)
            return true;
        
        return false;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++){
            if (natural(i, n))
                answer++;
        }

        return answer;
    }
}