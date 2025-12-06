import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();

        // Set에 담기
        for (int r : reserve) reserveSet.add(r);
        for (int l : lost) lostSet.add(l);

        // 1) 여벌 + 도난 중복 제거
        //   -> 자기 옷 있으므로 빌려줄 것도, 못 받는 것도 아님
        Set<Integer> intersection = new HashSet<>(lostSet);
        intersection.retainAll(reserveSet); // lost ∩ reserve

        lostSet.removeAll(intersection);
        reserveSet.removeAll(intersection);

        // 2) 잃어버린 학생 하나씩 처리
        for (int l : new HashSet<>(lostSet)) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                lostSet.remove(l);
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                lostSet.remove(l);
            }
        }

        // 3) 체육 수업 가능한 학생 = 전체 - 옷 못 빌린 학생 수
        return n - lostSet.size();
    }
}
