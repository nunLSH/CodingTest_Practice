import java.util.*;
import java.io.*;

class Main {
    public static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            cnt = 0;

            dfs(0, n);
            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }

    public static void dfs(int n, int target){
        if (n == target){
            cnt++;
            return;
        }

        if (n > target)
            return;

        dfs(n+1, target);
        dfs(n+2, target);
        dfs(n+3, target);
    }
}