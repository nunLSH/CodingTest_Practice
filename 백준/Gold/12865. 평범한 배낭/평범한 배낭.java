import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        for (int i = 1; i < n+1; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st2.nextToken()); // 무게
            value[i] = Integer.parseInt(st2.nextToken()); // 가치
        }

        // dp
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++){ // 무게
            for (int w = 0; w <= k; w++){ // 배낭 용량
                if (w < weight[i]) {
                    dp[i][w] = dp[i-1][w];   // 넣을 수 없으니까 안 넣는 선택만 가능
                } else {
                    dp[i][w] = Math.max(
                        dp[i-1][w],
                        dp[i-1][w - weight[i]] + value[i]
                    );
                }
            }
        }
        
        System.out.println(dp[n][k]);
    }
}