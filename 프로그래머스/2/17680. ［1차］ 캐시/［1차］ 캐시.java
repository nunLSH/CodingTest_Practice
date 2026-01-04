import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();

        // 캐시 크기가 0이면 전부 miss
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase();

            // 캐시 히트
            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city); // 기존 위치 제거
                cache.add(city);    // 가장 최근으로 이동
            }
            // 캐시 미스
            else {
                answer += 5;

                // 캐시가 꽉 찼으면 LRU 제거
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }

                cache.add(city);
            }
        }

        return answer;
    }
}
