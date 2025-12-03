import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            nums[i] = String.valueOf(numbers[i]);

        // 커스텀 정렬 (a+b vs b+a)
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // 0으로만 이루어진 경우
        if (nums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : nums)
            sb.append(s);

        return sb.toString();
    }
}
