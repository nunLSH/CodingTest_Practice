import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 수 배열
        int[] indegree = new int[N + 1];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
        
            graph[a].add(b);  
            indegree[b]++; 
        }

        // 진입차수 0 삽입
        for (int i = 1; i <= N; i++){
            if (indegree[i] == 0)
                q.add(i);
        }

        StringBuffer sb = new StringBuffer();

        while (!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(' ');

            for (int next : graph[cur]){
                if (--indegree[next] == 0)
                    q.add(next);
            }
        }  

        System.out.print(sb.toString());
    }
}