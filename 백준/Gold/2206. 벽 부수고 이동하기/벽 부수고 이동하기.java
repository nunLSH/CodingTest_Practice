import java.util.*;
import java.io.*;

class Main {
    public static int n, m;
    public static int[][] map;
    public static int[] dx = new int[]{0, 0, -1, 1}; // 상하좌우
    public static int[] dy = new int[]{-1, 1, 0, 0};
    public static int[][][] dist;
    public static boolean[][][] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < m; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        bfs();
        
        if (dist[n-1][m-1][0] != 0 && dist[n-1][m-1][1] != 0)
            System.out.println(Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]));
        else if (dist[n-1][m-1][0] == 0 && dist[n-1][m-1][1] == 0)
            System.out.println(-1);
        else if (dist[n-1][m-1][0] == 0 || dist[n-1][m-1][1] == 0)
            System.out.println(Math.max(dist[n-1][m-1][0], dist[n-1][m-1][1]));
    }

    public static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        dist = new int[n][m][2];
        visited = new boolean[n][m][2];
        int min = Integer.MAX_VALUE;
        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        dist[0][0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];

            if(x == n-1 && y == m-1)
                return;
            
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny][broken]){
                    if (map[nx][ny] == 0){ // 벽을 부수지 않고 이동
                        visited[nx][ny][broken] = true;
                        dist[nx][ny][broken] = dist[x][y][broken] + 1;
                        q.offer(new int[]{nx, ny, broken});
                    } else if (broken == 0 && map[nx][ny] == 1){ // 벽을 부수고 이동
                        visited[nx][ny][1] = true;
                        dist[nx][ny][1] = dist[x][y][broken] + 1;
                        q.offer(new int[]{nx, ny, 1});
                    }
                }
            }
        }
    }

    public static boolean inRange(int x, int y){
        return (0 <= x && x < n && 0 <= y && y < m);
    }
}