class Solution {
    public int solution(String word) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int[] weight = {781, 156, 31, 6, 1};
        
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            int idx = 0;
            for (int j = 0; j < 5; j++) {
                if (vowels[j] == c) {
                    idx = j;
                    break;
                }
            }

            answer += idx * weight[i];

            answer += 1;
        }

        return answer;
    }
}
