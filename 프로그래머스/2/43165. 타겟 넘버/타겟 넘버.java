class Solution {
    public int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int n ,int sum, int target){
        
        if (n == numbers.length){
            if (sum == target)
                answer++;
            return;
        }
        
        dfs(numbers, n+1, sum + numbers[n], target);
        dfs(numbers, n+1, sum - numbers[n], target);
    }
}