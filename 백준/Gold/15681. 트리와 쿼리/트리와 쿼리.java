import java.util.*;
import java.io.*;

class Main {
    public static List<Integer>[] graph;
    public static List<Integer>[] tree;
    public static boolean[] visited;
    public static int[] size;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        for (int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();

        visited = new boolean[n+1];

        size = new int[n+1];
        size[r] = 1;
        // 트리 만들기
        makeTree(r);
        // 각 정점에 대한 서브트리 개수 구하기
        countSubtreeNodes(r);
        
        while(q -- > 0){
            int u = Integer.parseInt(br.readLine());
    
            System.out.println(size[u]);
        }
    }

    public static void makeTree(int parent){
        visited[parent] = true;

        for (int next : graph[parent]){
            if (!visited[next]){
                tree[parent].add(next);
                size[parent]++;
                makeTree(next);
            }
        }
    }

    public static int countSubtreeNodes(int cur){
        size[cur] = 1;
        
        for (int next : tree[cur]){
            countSubtreeNodes(next);
            size[cur] += size[next];
        }

        return size[cur];
    }
}