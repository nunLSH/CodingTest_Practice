class Solution {
    public int range;
    
    boolean inRange(int x, int y){
        return (0 <= x && x <= range - 1 && 0 <= y && y <= x);
    }
    
    public int[] solution(int n) {
        range = n;
        int maxNum = n * (n+1) / 2;
        
        // 삼각형 배열 생성
        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) 
            arr[i] = new int[i + 1]; 
        
        // 삼각형 배열 채우기
        int num = 1;
        int[] dx = new int[]{1, 0, -1}; // 아래, 옆, 위(왼대각선)
        int[] dy = new int[]{0, 1, -1};
        int dir = 0;
        int x = 0, y = 0;
        arr[x][y] = num++;
        
        while(num <= maxNum){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (inRange(nx, ny) && arr[nx][ny] == 0){
                arr[nx][ny] = num++;
                x = nx;
                y = ny;
            } else {
                dir++;
                if (dir == 3) dir = 0;
            }
        }
        
        // 1차원 배열에 채우기
        int[] answer = new int[maxNum];
        int idx = 0;
        
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j <= i; j++){
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}