import java.util.*;
import java.io.*;

class Main {
    public static final int MAX = 100000 * 2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            int pos = q.poll();

            if (pos == K) {
                System.out.println(dist[pos]);
                break;
            }

            int[] next = {pos + 1, pos - 1, pos * 2};
            for (int n : next) {
                if (0 <= n && n <= MAX && dist[n] == -1) {
                    dist[n] = dist[pos] + 1;
                    q.offer(n);
                }
            }
        }
    }
}