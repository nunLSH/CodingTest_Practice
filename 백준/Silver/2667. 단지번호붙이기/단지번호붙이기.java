import java.util.*;
import java.io.*;

class Main {
    public static int[] dx = new int[]{0, 1, 0, -1}; // 위 오 아 왼
    public static int[] dy = new int[]{-1, 0, 1, 0};
    public static boolean[][] visited;
    public static int[][] house;
    public static int n;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        house = new int[n][n];
        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < n; j++){
                house[i][j] = s.charAt(j) - '0';
            }
        }

        // DFS
        visited = new boolean[n][n];

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!visited[i][j] && house[i][j] == 1)
                    result.add(dfs(i, j));
            }
        }
        
        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result){
            System.out.println(num);
        }
    }

    public static int dfs(int x, int y){
        visited[x][y] = true;
    
        int count = 1; // 현재 집 포함
    
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
    
            if (inRange(nx, ny) && house[nx][ny] == 1 && !visited[nx][ny])
                count += dfs(nx, ny);
        }
    
        return count;
    }

    public static boolean inRange(int x, int y){
        return (0 <= x && x <= n-1 && 0 <= y && y <= n-1);
    }
    
}