import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cur = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}