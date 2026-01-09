class Solution {
    public int[] solution(int[] prices) {
        
        // 1 2 3 2 3 
        // 4 3 1 1 0
        
        // 가격이 떨어졌다? 뒤에 나온 수가 나보다 작을 때
        // 초가 넘아가면 무조건 1초 증가
        // 나보다 작다 > 거기서 끝
        // 나보다 크거나 같다 > 다음
        int len = prices.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++){
            for (int j = i+1; j < len; j++){
                if (prices[i] <= prices[j])
                    answer[i]++;
                else {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        
        return answer;
    }
}