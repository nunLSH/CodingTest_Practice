import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] color = new int[n+1][3];
        for (int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[n+1][3];
        for (int i = 1; i <= n; i++){
            dp[i][0] = color[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = color[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = color[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        
        int minCost = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(minCost);
    }
}