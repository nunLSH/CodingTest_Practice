import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        ArrayList<String> arr = new ArrayList<>();
        arr.add(words[0]);

        for (int i = 1; i < words.length; i++){
            int last = words[i-1].length() - 1;

            if (words[i-1].charAt(last) != words[i].charAt(0)
               || arr.contains(words[i])
               || words[i].length() < 2 || words[i].length() > 50) {

                answer[0] = (i+1) % n == 0 ? n : (i+1) % n;
                answer[1] = (i+1) % n == 0 ? (i+1) / n : (i+1) / n + 1;
                break;
        
            } else 
                arr.add(words[i]);
        }
        
        return answer;
    }
}