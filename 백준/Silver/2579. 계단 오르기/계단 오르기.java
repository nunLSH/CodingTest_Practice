import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] steps = new int[n+1];
        for (int i = 1; i <= n; i++)
            steps[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1]; // i번째 계단을 반드시 밟고 도착했을 때 최대값
        dp[1] = steps[1];
        
        if (n >= 2)
            dp[2] = steps[1] + steps[2];
        
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                dp[i-2] + steps[i],
                dp[i-3] + steps[i-1] + steps[i]
            );
        }

        System.out.println(dp[n]);
    }
}