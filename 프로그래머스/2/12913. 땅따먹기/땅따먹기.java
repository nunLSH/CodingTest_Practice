class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];

        for (int y = 0; y < 4; y++) {
            dp[0][y] = land[0][y];
        }

        // 두번째 행부터 DP
        for (int x = 1; x < n; x++) {
            for (int y = 0; y < 4; y++) {
                int maxPrev = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != y) {
                        maxPrev = Math.max(maxPrev, dp[x - 1][k]);
                    }
                }
                dp[x][y] = land[x][y] + maxPrev;
            }
        }

        int answer = 0;
        for (int y = 0; y < 4; y++) {
            answer = Math.max(answer, dp[n - 1][y]);
        }

        return answer;
    }
}
