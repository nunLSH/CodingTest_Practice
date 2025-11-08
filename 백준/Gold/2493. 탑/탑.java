import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] towers = new int[n + 1];
        int[] result = new int[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            towers[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && towers[stack.peek()] <= towers[i])
                stack.pop();

            result[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }

        // 출력 모으기
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
