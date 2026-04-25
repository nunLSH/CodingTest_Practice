import java.util.*;
import java.io.*;

class Main {
    public static int[][] graph;
    public static int[] dy = new int[]{0, 0, -1, 1}; // 상하좌우
    public static int[] dx = new int[]{-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 미로 생성
        graph = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            String s = br.readLine();
            for (int j = 1; j <= m; j++){
                graph[i][j] = s.charAt(j-1) - '0';
            }
        }

        // BFS
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 1});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == n && y == m)
                break;

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (1 <= nx && nx <= n && 1 <= ny && ny <= m){
                    if (graph[nx][ny] == 1){
                        q.offer(new int[]{nx, ny});
                        graph[nx][ny] = graph[x][y] + 1;
                    }
                }
            }
        }

        System.out.println(graph[n][m]);
    }
}