class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a > 0 && b > 0){
            if (Math.abs(a-b) == 1){
                if (a > b){
                    if (a % 2 == 0 && b % 2 == 1){
                        answer++;
                        break;
                    }
                } else {
                    if (b % 2 == 0 && a % 2 == 1){
                        answer++;
                        break;
                    }
                }
            }
            
            if (a % 2 == 0) a /= 2;
            else a = (a + 1) / 2;
            
            if (b % 2 == 0) b /= 2;
            else b = (b + 1) / 2;
                
            answer++;
        }
        
        return answer;
    }
}