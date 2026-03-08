import java.util.*;
import java.io.*;

class Main {
    public static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 그래프 채우기
        int[][] graph = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            String s = br.readLine();
            for (int j = 1; j <= m; j++){
                graph[i][j] =s.charAt(j-1) - '0';
            }
        }

        // BFS
        boolean[][] visited = new boolean[n+1][m+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 1, 1});
        visited[1][1] = true;

        int[] dx = new int[]{0, 1, 0, -1}; // 위 오 아 왼
        int[] dy = new int[]{-1, 0, 1, 0};

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == n && y == m){
                System.out.println(dist);
                break;
            }

            for (int i = 0; i <= 3; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && graph[nx][ny] == 1 && !visited[nx][ny]){
                    q.offer(new int[]{nx, ny, dist+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean inRange(int x, int y){
        return (1 <= x && x <= n && 1 <= y && y <= m);
    }
}