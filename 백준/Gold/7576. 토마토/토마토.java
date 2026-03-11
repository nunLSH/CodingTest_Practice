import java.util.*;
import java.io.*;

class Main {
    public static int[][] tomato;
    public static int n, m;
    public static int[] dx = new int[]{-1, 1, 0, 0}; // 왼 오 앞 뒤
    public static int[] dy = new int[]{0, 0, 1, -1};
    public static int day = 0;
    public static int cntTomato = 0;
    public static int noTomato = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 토마토 채우기
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomato = new int[n][m];

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                tomato[i][j] = Integer.parseInt(st2.nextToken());
                if (tomato[i][j] == 1){
                    cntTomato++;
                    q.offer(new int[]{i, j, 0});
                } else if (tomato[i][j] == -1)
                    noTomato++;
            }
        }

        // 저장될 때부터 익어있는 상태
        if (cntTomato == n * m - noTomato){
            System.out.println(0);
            return;
        }
            

        // BFS
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (inRange(nx, ny) && tomato[nx][ny] == 0){
                    tomato[nx][ny] = 1;
                    cntTomato++;
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                    day = cur[2] + 1;
                }
            }
        }

        if (cntTomato == n * m - noTomato)
            System.out.println(day);
        else
            System.out.println(-1);
    }

    public static boolean inRange(int x, int y){
        return (0 <= x && x < n && 0 <= y && y < m);
    }
}