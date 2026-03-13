import java.util.*;
import java.io.*;

class Main {
    public static int[] dx = new int[]{0, 0, -1, 1}; // 상 하 좌 우
    public static int[] dy = new int[]{-1, 1, 0, 0};
    public static int[][] lab;
    public static int n, m;
    public static int safe = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 연구소
        lab = new int[n][m];
        for (int i = 0; i < n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                lab[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 벽 세우기 (DFS) > 바이러스 퍼뜨리기 (BFS)
        dfs(0, 0);

        System.out.println(safe);
    }

    public static void dfs(int start, int count){
        // 벽 3개 세움
        if (count == 3){
            // 맵 복사
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++)
                map[i] = lab[i].clone();
            
            // 바이러스 퍼뜨리고 안전구역 영역 계산
            safe = Math.max(bfs(map), safe);
            return;
        }
    
        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;
    
            if (lab[x][y] == 0) {
                lab[x][y] = 1;
                dfs(i + 1, count + 1);
                lab[x][y] = 0;
            }
        }
    }

    public static int bfs(int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();

        // 바이러스 큐에 넣기
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (map[i][j] == 2)
                    q.offer(new int[]{i, j});
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0){
                    map[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // 안전구역 개수 세기
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 0)
                    cnt++;
            }
        }
        
        return cnt;
    }
}