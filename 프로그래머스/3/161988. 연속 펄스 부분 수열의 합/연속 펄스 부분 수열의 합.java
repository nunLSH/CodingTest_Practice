class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        long sum1 = 0; // 1, -1, 1, -1 ...
        long sum2 = 0; // -1, 1, -1, 1 ...

        for (int i = 0; i < sequence.length; i++) {
            int pulse1 = (i % 2 == 0) ? 1 : -1;
            int pulse2 = -pulse1;

            long num1 = sequence[i] * pulse1;
            long num2 = sequence[i] * pulse2;

            sum1 = Math.max(num1, sum1 + num1);
            sum2 = Math.max(num2, sum2 + num2);

            answer = Math.max(answer, Math.max(sum1, sum2));
        }

        return answer;
    }
}