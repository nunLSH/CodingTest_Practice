class Solution {
    long[] cnt = new long[2001];
    
    public long cnt (int n){
        if (n == 0 || n == 1)
            return 1;
        
        if (cnt[n] != 0) 
            return cnt[n];
        
        cnt[n] = (cnt(n-1) + cnt(n-2)) % 1234567;
        
        return cnt[n];
    }
    
    public long solution(int n) {
        return cnt(n);
    }
}