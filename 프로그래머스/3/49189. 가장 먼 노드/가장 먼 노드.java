import java.util.*;
class Node {
    int vertex;
    Node next;

    Node(int vertex, Node next) {
        this.vertex = vertex;
        this.next = next;
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Node[] adj = new Node[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        
        for (int[] e : edge){
            int u = e[0];
            int v = e[1];
            
            // 양방향
            adj[u] = new Node(v, adj[u]);
            adj[v] = new Node(u, adj[v]);
        }
        
        visited[1] = true;
        queue.offer(1);
        int dis = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            Node next = adj[cur];
            
            while (next != null){
                if (visited[next.vertex] == false){
                    visited[next.vertex] = true;
                    distance[next.vertex] = distance[cur] + 1;
                    queue.offer(next.vertex);
                }
                
                next = next.next;
            }
        }
        
        // 배열에서 최댓값 구하기
        int maxDistance = Arrays.stream(distance).max().getAsInt();
        
        for (int i : distance){
            if (i == maxDistance)
                answer++;
        }
    
        return answer;
    }
} 