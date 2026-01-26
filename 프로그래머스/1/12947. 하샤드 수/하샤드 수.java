class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int temp = x;

        // 각 자리 숫자의 합 구하기
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        // x가 자릿수 합으로 나누어 떨어지는지 확인
        return x % sum == 0;
    }
}
