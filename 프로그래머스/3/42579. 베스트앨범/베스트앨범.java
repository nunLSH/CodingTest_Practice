import java.util.*;
import java.util.stream.Collectors;

class Song {
    int plays;
    int index;

    public Song(int plays, int index){
        this.plays = plays;
        this.index = index;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genreTotal = new HashMap<>();
        HashMap<String, List<Song>> map = new HashMap<>();

        // 1️⃣ Map 구성
        for (int i = 0; i < plays.length; i++){
            genreTotal.put(genres[i],
                    genreTotal.getOrDefault(genres[i], 0) + plays[i]);

            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new Song(plays[i], i));
        }

        // 장르 정렬 (총 재생수 기준)
        List<String> sortedGenres = genreTotal.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();

        // 장르별 노래 처리
        for (String genre : sortedGenres) {
            List<Song> songList = map.get(genre);

            // 장르 내부 정렬
            songList.sort((a, b) -> {
                if (b.plays != a.plays) return b.plays - a.plays;
                return a.index - b.index;
            });

            // 상위 2개 선택
            for (int i = 0; i < Math.min(2, songList.size()); i++) {
                answer.add(songList.get(i).index);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}