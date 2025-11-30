import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        for (int[] e : edge){
            int u = e[0];
            int v = e[1];
            
            graph[u].add(v);
            graph[v].add(u);   
        }
        
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        
        visited[1] = true;
        queue.offer(1);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    dist[nxt] = dist[cur] + 1;
                    queue.offer(nxt);
                }
            }
        }
        
        // 배열에서 최댓값 구하기
        int maxDistance = Arrays.stream(dist).max().getAsInt();
        
        for (int i : dist){
            if (i == maxDistance)
                answer++;
        }
    
        return answer;
    }
} 