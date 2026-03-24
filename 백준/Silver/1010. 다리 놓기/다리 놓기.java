import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 조합 미리 계산 (파스칼 삼각형)
        for(int i = 0; i <= 30; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i = 2; i <= 30; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[M][N]).append("\n");
        }

        System.out.print(sb);
    }
}