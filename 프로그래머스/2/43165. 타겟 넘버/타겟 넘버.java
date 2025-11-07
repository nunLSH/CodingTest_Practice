class Solution {
    public int answer;
    public void dfs(int[] numbers, long sum, int target, int i){
        if (i == numbers.length - 1){
            if (sum - numbers[i] == target || sum + numbers[i] == target)
                answer++;
            
            return;
        }
        
        dfs(numbers, sum - numbers[i], target, i + 1);
        dfs(numbers, sum + numbers[i], target, i + 1);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, target, 0);
        return answer;
    }
}