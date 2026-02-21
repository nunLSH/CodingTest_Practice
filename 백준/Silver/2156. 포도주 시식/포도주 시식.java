import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n];

        for (int i = 0; i < n; i++)
            wines[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        int[][] dp = new int[n][3];
        dp[0][0] = 0; 
        dp[0][1] = wines[0];
        for (int j = 1; j < n; j++){
            dp[j][0] = Math.max(Math.max(dp[j-1][0], dp[j-1][1]), dp[j-1][2]); 
            dp[j][1] = dp[j-1][0] + wines[j];
            dp[j][2] = dp[j-1][1] + wines[j];
        }
        
        int max = Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        System.out.print(max);
    }
}