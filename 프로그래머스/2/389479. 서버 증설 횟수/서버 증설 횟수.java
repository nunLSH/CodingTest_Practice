class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] servers = new int[24];
        for (int i = 0; i < 24; i++){
            // 이용자 수와 운영 중인 기존 서버 수 비교
            if (players[i] / m > servers[i]){
                int prev = servers[i]; // 기존 서버 수
                int add = players[i] / m - prev; // 증설해야 하는 서버 수
                
                for (int j = i; j < i + k; j++){
                    if (j > 23) break;
                    servers[j] += add;
                }
                
                answer += add;
            }
        }
        
        return answer;
    }
}