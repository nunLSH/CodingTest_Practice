import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int b = 0;

        for (int a : A) {
            while (b < B.length && B[b] <= a) {
                b++;
            }

            if (b < B.length) {
                answer++;
                b++;
            }
        }

        return answer;
    }
}