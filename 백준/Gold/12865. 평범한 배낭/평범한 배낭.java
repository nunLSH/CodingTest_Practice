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

        // dp >> GPT의 도움으로 개선한 코드
        int[] dp = new int[k+1];
        for (int i = 1; i <= n; i++) {
            for (int w = k; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
            }
        }
        
        System.out.println(dp[k]);
    }
}