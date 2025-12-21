class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left + 1);
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            long idx = left + i;
            int row = (int)(idx / n);
            int col = (int)(idx % n);

            arr[i] = Math.max(row, col) + 1;
        }

        return arr;
    }
}
