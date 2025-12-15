import java.util.*;
class Solution {
    public int answer = -1;
    public void dfs(int energy, int cnt, 
                    Stack<Integer> stack, boolean[] visited, int[][] dungeons){
        while (!stack.isEmpty()){
                stack.pop();
                
            for (int j = 0; j < dungeons.length; j++){
                if (energy >= dungeons[j][0]){
                    if (visited[j] == false){
                        energy -= dungeons[j][1];
                        stack.push(j);
                        visited[j] = true;
                        
                        dfs(energy, cnt + 1, stack, visited, dungeons);

                        visited[j] = false;
                        energy += dungeons[j][1];
                    } else
                        continue;
                } else{
                    answer = Math.max(cnt, answer);
                }
            }
        }
        
        return; 
    }
    public int solution(int k, int[][] dungeons) {   
    
        for (int i = 0; i < dungeons.length; i++){ // 시작점
            int energy = k;
            int cnt = 0;
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[dungeons.length];   
            
            if (energy >= dungeons[i][0]){
                energy -= dungeons[i][1];
                visited[i] = true;
                stack.push(i);
                cnt++;
                
                dfs(energy, cnt, stack, visited, dungeons);
            }
        }

        return answer;
    }
}