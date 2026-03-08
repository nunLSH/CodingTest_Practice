import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[][] graph;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(graph[n-1][m-1]);
    }

    // GPT 개선 풀이
    // visited 배열 없이 graph로 방문 처리 및 칸 수 계산
    static void bfs(){

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m && graph[nx][ny]==1){

                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}