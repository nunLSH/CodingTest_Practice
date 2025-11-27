import java.util.*;
class Solution {
    public int n, m;
    public int[] dx = {0, 0, 1, -1}; // 행 - 동 서 남 북
    public int[] dy = {1, -1, 0, 0}; // 열
    
    public boolean inRange(int x, int y){
        return (0 <= x && x < n && 0 <= y && y < m);
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        // 상대팀 진영 진입불가
        // if (maps[n-1][m-2] == 0 && maps[n-2][m-1] == 0)
        //     return -1;
        
        // 진입 가능
        int answer = -1; // 중간에 벽이 있을 경우
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if (cur[0] == n - 1 && cur[1] == m - 1){
                answer = cur[2];
                break;
            }
            
            for (int i = 0; i < 4; i++){
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];
                int dis = cur[2] + 1;

                if (inRange(nX, nY) && maps[nX][nY] == 1 && visited[nX][nY] == false)                 {
                    visited[nX][nY] = true;
                    queue.offer(new int[]{nX, nY, dis});
                }
            }
        }
        
        return answer;
    }
}