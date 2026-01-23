class Solution {    
    public int solution(int n) {
        
        long[] dp = new long[n+1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        long answer = calc(n, dp);
        
        return (int) answer % 1000000007;
    }
    
    public long calc(int n, long[] dp){
        if (n == 0)
            return 1;
        
        if (n < 0)
            return 0;
        
        if (dp[n] != 0)
            return dp[n] % 1000000007;

        dp[n] = calc(n - 1, dp) + calc(n - 2, dp);
        
        return dp[n] % 1000000007;
    }
}