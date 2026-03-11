import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[][] tomato;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        tomato = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.offer(new int[]{i, j}); // 시작점
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (tomato[nx][ny] != 0) continue;

                tomato[nx][ny] = tomato[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0) { // 안 익은 토마토 존재
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, tomato[i][j]);
            }
        }

        System.out.println(result - 1); // 처음 익은 토마토를 1로 시작했기 때문에 -1
    }
}