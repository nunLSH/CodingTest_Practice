import java.util.*;
import java.io.*;

// DP로 재풀이
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n+1];
            dp[0] = 1; // 아무것도 더하지 않는 방법도 1가지
            if (n >= 1) dp[1] = 1;
            if (n >= 2) dp[2] = 2;

            if (n >= 3){
                for (int j = 3; j <= n; j++)
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
