import java.util.*;
import java.io.*;

class Main {
    public static List<Integer>[] graph;
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
        
        // DFS
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n+1];
        dfs(v, visited, sb);
        System.out.println(sb.toString());

        // BFS
        StringBuilder sb2 = new StringBuilder();
        boolean[] visited2 = new boolean[n+1];
        bfs(v, sb2, visited2);
        System.out.println(sb2.toString());
    }

    public static void dfs(int cur, boolean[] visited, StringBuilder sb){
        visited[cur] = true;
        sb.append(cur).append(" ");

        Collections.sort(graph[cur]);
        for (int i = 0; i < graph[cur].size(); i++){
            if (!visited[graph[cur].get(i)] == true)
                dfs(graph[cur].get(i), visited, sb);
        }
    }

    public static void bfs(int start, StringBuilder sb2, boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            sb2.append(cur).append(" ");

            Collections.sort(graph[cur]);
            for (int i = 0; i < graph[cur].size(); i++){
                if (!visited[graph[cur].get(i)] == true) {
                    q.offer(graph[cur].get(i));
                    visited[graph[cur].get(i)] = true;
                }
            }
        }
    }
}