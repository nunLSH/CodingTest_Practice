import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // 인접리스트 만들기
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] w : wires) {
            int a = w[0];
            int b = w[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // 하나씩 끊어서 서브트리의 노드 개수 구하기 (BFS)
        for (int i = 0; i < wires.length; i++){
            int subCntA = 0;
            int subCntB = 0;
            int cutA = wires[i][0];
            int cutB = wires[i][1];
            boolean[] visited = new boolean[n+1];
            
            Queue<Integer> q = new ArrayDeque<>();
            visited[cutA] = true;
            q.offer(cutA);
            
            while (!q.isEmpty()){
                int cur = q.poll();
                
                for (int next : graph[cur]) {
                    if (visited[next]) continue; 
                    
                    if (cur == cutA && next == cutB ||
                       cur == cutB && next == cutA)
                        continue;
                    
                    visited[next] = true;
                    q.offer(next);
                }
            }
            
            for (int j = 1; j < visited.length; j++){
                if (visited[j] == true)
                    subCntA++;
            }
            
            subCntB = n - subCntA;
            
            answer = Math.min(answer, Math.abs(subCntA - subCntB));
        }
        
        return answer;
    }
}