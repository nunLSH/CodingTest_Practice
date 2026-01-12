class Solution {
    public int solution(String dirs) {
        boolean[][][] visited = new boolean[11][11][4];
        
        int[] dx = new int[]{0, -1, 1, 0};
        int[] dy = new int[]{1, 0, 0, -1};
        
        int curX = 0, curY = 0;
        int distance = 0;
        int dir = 0;
        
        for (int i = 0; i < dirs.length(); i++){
            char curDir = dirs.charAt(i);
            
            if (curDir == 'U')
                dir = 0;
            else if (curDir == 'L')
                dir = 1;
            else if (curDir == 'R')
                dir = 2;
            else 
                dir = 3;
            
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];

            if (inRange(nx, ny)){
                if (visited[nx+5][ny+5][dir] == false){
                    distance++;
                    visited[nx+5][ny+5][dir] = true;
                    visited[curX+5][curY+5][3-dir] = true;
                }
                curX = nx;
                curY = ny;
            }
        }
        
        return distance;
    }
    
    public boolean inRange(int x, int y){
        return (-5 <= x &&  x <= 5 && -5 <= y && y <= 5);
    }
}