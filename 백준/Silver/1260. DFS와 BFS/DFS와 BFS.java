import java.util.*;
import java.io.*;

class Main {
    public static List<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 배열 생성
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        // 그래프 채우기
        for (int i = 0; i < m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        
        // 그래프 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        
        // DFS
        visited = new boolean[n+1];
        dfs(v);
        System.out.println();

        // BFS
        visited = new boolean[n+1];
        bfs(v);
    }

    static void dfs(int cur) {

        visited[cur] = true;
        System.out.print(cur + " ");

        for (int next : graph[cur]) {
            if (!visited[next])
                dfs(next);
        }
    }

    static void bfs(int start) {

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int cur = q.poll();
            System.out.print(cur + " ");

            for (int next : graph[cur]) {

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}