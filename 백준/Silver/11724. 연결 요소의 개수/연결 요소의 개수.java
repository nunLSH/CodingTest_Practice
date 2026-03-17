import java.util.*;
import java.io.*;

class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] arr;
    public static int count = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = new ArrayList<>();
    
        for (int i = 0; i < m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());

            arr[u].add(v);
            arr[v].add(u);   
        }

        // DFS
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int cur) {
        visited[cur] = true;

        for (int next : arr[cur]){
            if (!visited[next])
                dfs(next);
        }
    }
}