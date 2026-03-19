import java.util.*;
import java.io.*;

class Main {
    public static char[][] graph;
    public static boolean[][] visited;
    public static int n;
    public static int nonBlindnessCnt = 0;
    public static int blindnessCnt = 0;
    public static int[] dx = new int[]{0, 0, -1, 1}; // 상, 하, 좌, 우
    public static int[] dy = new int[]{-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];
        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < n; j++)
                graph[i][j] = s.charAt(j);
        }

        visited = new boolean[n][n];

        char color;

        // 적록색약 아님
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!visited[i][j]){
                    color = graph[i][j];
                    nonBlindness(i, j, color);
                    nonBlindnessCnt++;
                }
            }
        }

        // visited 초기화
        visited = new boolean[n][n];

        // 적록색약
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!visited[i][j]){
                    color = graph[i][j];
                    blindness(i, j, color);
                    blindnessCnt++;
                }
            }
        }

        System.out.println(nonBlindnessCnt + " " + blindnessCnt);
    }

    // 적록색약이 아닌 사람
    public static void nonBlindness(int x, int y, char curColor){
        visited[x][y] = true;

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n){
                if(!visited[nx][ny] && graph[nx][ny] == curColor){
                    nonBlindness(nx, ny, curColor);
                }
            }
        }
    }

    // 적록색약
    public static void blindness(int x, int y, char curColor){
        visited[x][y] = true;

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n){
                if(!visited[nx][ny]){
                    if (curColor == 'R' || curColor == 'G'){
                        if(graph[nx][ny] == 'R' || graph[nx][ny]== 'G')
                            blindness(nx, ny, curColor);
                    } else {
                        if (graph[nx][ny] == curColor)
                            blindness(nx, ny, curColor);
                    }
                }
            }
        }
    } 
}