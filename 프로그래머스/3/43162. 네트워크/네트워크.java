class Solution {
    public boolean[] visited = new boolean[200];
    
    public void dfs (int cur, int[][] computers, boolean[] visited){
        visited[cur] = true;
        
        for (int i = 0; i < computers.length; i++){
            if (computers[cur][i] == 1 && visited[i] == false){
                dfs (i, computers, visited);
            }
        }
        
        return;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for (int i = 0; i < computers.length; i++){
            if (!visited[i]){
                dfs(i, computers, visited);
                answer++;
            }
        }
                
        return answer;
    }
}