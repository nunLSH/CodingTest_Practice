import java.util.*;
import java.io.*;

class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[n + 1][10];

        // 초기값
        for (int i = 1; i <= 9; i++)
            dp[1][i] = 1;

        // DP
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];

            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[n][i]) % MOD;
        }

        System.out.println(answer);
    }
}