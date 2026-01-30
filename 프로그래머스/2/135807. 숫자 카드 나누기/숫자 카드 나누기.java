import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        answer = isTrue(arrayA, arrayB);
        answer = Math.max(answer, isTrue(arrayB, arrayA));
        
        return answer;
    }
    
    public int isTrue(int[] arr1, int[] arr2){
        int gcd = 0;
        for (int i = 0; i < arr1.length; i++)
            gcd = getGCD(gcd, arr1[i]);
        
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] % gcd != 0)
                return 0;
            
            if (arr2[i] % gcd == 0)
                return 0;
        }
        
        return gcd;
    }
    
    public int getGCD(int a, int b){
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}