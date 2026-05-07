class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        // 최고의 집합이 존재하지 않는 경우 출력
        if (n > s) return new int[]{-1};
        
        // 그리디?
        // 최대한 나눠지는 원소들이 차이가 적어야 곱이 커진다
        int share = s / n;
        int remain = s % n;
        
        for (int i = 0; i < n; i++){
            if (i < n - remain)
                answer[i] = share;
            else
                answer[i] = share + 1;
        }
        
        
        return answer;
    }
}