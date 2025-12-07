import java.util.*;
class Solution {
    public int rm, rn;
    public boolean range(int x, int y){
        return (1 <= x && x <= rm && 1 <= y && y <= rn);
    }
    
    public long solution(int m, int n, int[][] puddles) {
        rm = m;
        rn = n;
        
        int[] dm = {1, 0}; // 오, 아래
        int[] dn = {0, 1}; 
        int[][] region = new int[m+1][n+1];
        int[][] road = new int[m+1][n+1];  // dp
        int mod = 1000000007;
    
        // 물이 잠긴 지역
        for (int i = 0; i < puddles.length; i++)
            region[puddles[i][0]][puddles[i][1]] = -1;
        
        road[1][1] = 1;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (i == 1 && j == 1)
                    continue;
                else if (region[i][j] == -1)
                    continue;
                else {
                    road[i][j] = (road[i-1][j] + road[i][j-1]) % mod;
                }
            }
        }
        
        
        return road[m][n];
    }
}