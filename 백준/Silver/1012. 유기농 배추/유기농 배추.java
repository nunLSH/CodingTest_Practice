import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int m, n, k;
    public static boolean[][] visited;
    public static int[][] cabbage;
    public static int[] dx = new int[]{0, 0, -1, 1}; // 상하좌우
    public static int[] dy = new int[]{-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++)
            System.out.println(cabbageWorm(br));
    }

    public static int cabbageWorm(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 배추밭 채우기
        cabbage = new int[m][n];
        for (int i = 0; i < k; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st2.nextToken()); 
            int y =  Integer.parseInt(st2.nextToken()); 
            cabbage[x][y] = 1;
        }

        // DFS
        int cnt = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (cabbage[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny) && cabbage[nx][ny] == 1 && !visited[nx][ny])
                dfs(nx, ny);
        }

        return;
    }

    public static boolean inRange(int x, int y){
        return (0 <= x && x < m && 0 <= y && y < n);
    }
}