import java.util.*;
import java.io.*;

class Main {
    public static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        
        System.out.println(dp[n]);
    }
}