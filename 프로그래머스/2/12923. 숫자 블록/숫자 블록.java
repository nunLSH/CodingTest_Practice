class Solution {
    public long[] solution(long begin, long end) {
        
        // 그리디로 푸는 문제인가?
        // 각 구역별로 10,000,000 내의 약수 중에서 가장 큰 약수가 블록에 적힌 숫자 (자기자신 제외)
        // 각 구역 별 약수 구하기 >> 시간 복잡도 고려
        int size = (int)(end - begin + 1);
        long[] answer = new long[size];

        for (long i = begin; i <= end; i++) {
            answer[(int)(i - begin)] = greatestDivisor(i);
        }

        return answer;
    }
    
    // 약수 중 최대값을 구하는 함수
    public long greatestDivisor(long n) {
        if (n == 1) return 0; // ** n == 1일 때를 고려하지 못함

        long max = 1;

        for (long i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                long pair = n / i;

                if (pair <= 10_000_000) {
                    return pair;
                }

                max = i;
            }
        }

        return max;
    }
}