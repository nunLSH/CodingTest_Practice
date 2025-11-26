class Solution {
    public void dfs(int level, int[][] triangle, int[][] dp){
        if (level == triangle.length)
            return;
        
        for (int pos = 0; pos < triangle[level].length; pos++){
            if (pos == 0)
                dp[level][pos] = triangle[level][pos] + dp[level-1][pos];
            else
                dp[level][pos] = triangle[level][pos] 
                + Math.max(dp[level-1][pos-1], dp[level-1][pos]);
        }
        
        dfs(level + 1, triangle, dp);

        return;
    }
    
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        dfs(1, triangle, dp);
        
        int maxSum = 0;
        int lastLevel = triangle.length;
        for (int i = 0; i < triangle[lastLevel - 1].length; i++)
            maxSum = Math.max(dp[lastLevel - 1][i], maxSum);
        
        return maxSum;
    }
}