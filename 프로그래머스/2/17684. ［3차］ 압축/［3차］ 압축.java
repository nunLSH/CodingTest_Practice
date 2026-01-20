import java.util.*;

class Solution {
    public Map<String, Integer> dictionary = new HashMap<>();
    
    public int[] solution(String msg) {
        List<Integer> idxNums = new ArrayList<>();
        
        // 1 ~ 26까지 사전에 등재
        int alphaIdx = 65;
        for (int i = 1; i <= 26; i++){
            String alphabet = String.valueOf((char) alphaIdx);
            dictionary.put(alphabet, i);
            alphaIdx++;
        }
        
        // 사전에 등재된 문자열 중 가장 긴 문자열 탐색
        // 없으면 사전 등재
        int searchIdx = 0; // 탐색 인덱스
        int newIdx = 27; // 등록 인덱스
        while (searchIdx < msg.length()){
            // 사전에 등재된 문자열 길이 탐색
            int len = isLenListed(msg, searchIdx);
            
            // 사전에 등재된 색인을 출력 배열에 추가
            String find = msg.substring(searchIdx, searchIdx + len);
            idxNums.add(dictionary.get(find));
            
            // 그 다음 길이 등재
            if (searchIdx + len + 1 < msg.length())
                dictionary.put(msg.substring(searchIdx, searchIdx + len + 1), 
                               newIdx);
                
            searchIdx += len;
            newIdx++;
        }
        
        int[] answer = new int[idxNums.size()];
        for (int i = 0; i < idxNums.size(); i++)
            answer[i] = idxNums.get(i);
            
        return answer;
    }
    
    // 해당 문자열이 등재되어 있는지 확인
    public int isLenListed(String str, int idx){
        int len = 1;
        boolean isAble = true;
        while (idx + len <= str.length() &&
           dictionary.containsKey(str.substring(idx, idx + len))) {
            len++;
        }   
        
        return len - 1;
    }
}