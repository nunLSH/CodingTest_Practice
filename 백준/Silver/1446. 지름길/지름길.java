import java.util.*;
import java.io.*;

class Shortcut {
    int end;
    int len;

    public Shortcut(int end, int len) {
        this.end = end;
        this.len = len;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<Shortcut>[] graph = new ArrayList[d + 1];
        for (int i = 0; i <= d; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            // 도착점이 d를 넘거나, 지름길이 원래 길보다 이득이 없으면 제외
            if (end > d) continue;
            if (end - start <= len) continue;

            graph[start].add(new Shortcut(end, len));
        }

        int[] dist = new int[d + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < d; i++) {
            // 일반 도로로 1칸 이동
            dist[i + 1] = Math.min(dist[i + 1], dist[i] + 1);

            // i에서 시작하는 지름길들 사용
            for (Shortcut next : graph[i]) {
                dist[next.end] = Math.min(dist[next.end], dist[i] + next.len);
            }
        }

        System.out.println(dist[d]);
    }
}