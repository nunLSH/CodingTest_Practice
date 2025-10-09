class Solution {
    public int getGCD(int a, int b){
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    public int solution(int[] arr) {
        int answer = (arr[0] * arr[1]) / getGCD(arr[0], arr[1]);
        
        for (int i = 2; i < arr.length; i++){
            int gcd = getGCD(answer, arr[i]);
            answer = (answer * arr[i]) / gcd;
        }
        return answer;
    }
}