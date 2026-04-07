import java.util.*;
import java.io.*;

class Main {
    public static List<Integer>[] tree;
    public static boolean[] visited;
    public static int[] size;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();
        
        for (int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        size = new int[n+1];
        countSubtreeNodes(r, 0);

        StringBuilder sb = new StringBuilder();
        while(q -- > 0){
            int u = Integer.parseInt(br.readLine());
            sb.append(size[u]).append('\n');
        }

        System.out.print(sb);
    }

    public static int countSubtreeNodes(int cur, int parent){
        size[cur] = 1;
        
        for (int next : tree[cur]){
            if (next == parent) continue; 
            countSubtreeNodes(next, cur);
            size[cur] += size[next];
        }

        return size[cur];
    }
}