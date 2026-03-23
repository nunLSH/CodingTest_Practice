import java.util.*;
import java.io.*;

class Main {
    public static final int MAX = 200000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1); // -1이면 방문 안 함
        Deque<Integer> dq = new ArrayDeque<>();

        dist[n] = 0; // 시작점 시간 0초
        dq.offerFirst(n);

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            if (cur == k) {
                System.out.println(dist[cur]);
                break;
            }

            // 0초 이동
            int teleport = cur * 2;
            if (teleport <= MAX && dist[teleport] == -1) {
                dist[teleport] = dist[cur];
                dq.offerFirst(teleport); // 앞에 넣음 → 우선 처리
            }

            // 1초 이동
            for (int next : new int[]{cur - 1, cur + 1}) {
                if (next >= 0 && next <= MAX && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    dq.offerLast(next); // 뒤에 넣음 → 나중 처리
                }
            }
        }
    }
}