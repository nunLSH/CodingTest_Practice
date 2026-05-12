class Solution {
    public int answer = 0;
    public int goal;
    
    public int solution(int[] numbers, int target) {
        goal = target;
        
        dfs(numbers, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int n ,int sum){
        
        if (n == numbers.length){
            if (sum == goal)
                answer++;
            return;
        }
        
        dfs(numbers, n+1, sum + numbers[n]);
        dfs(numbers, n+1, sum - numbers[n]);
    }
}