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
        
        int prev2 = 1;
        int prev1 = 1;
        
        for (int i = 2; i <= n; i++) {
            int prev = (prev1 + 2 * prev2) % 10007;
            prev2 = prev1;
            prev1 = prev;
        }
        
        System.out.println(prev1);
    }
}