import java.util.*;
class Solution {
    public final int MAX = 1000;
    public int solution(int[] array) {
        ArrayList<Integer> cnt = new ArrayList<>();
        
        int[] arr = new int[MAX];
        for (int i = 0; i < array.length; i++)
            arr[array[i]]++;
        
        int maxCnt = arr[0];
        int answer = 0;
        for (int i = 0; i < MAX; i++){
            if (arr[i] == 0)
                continue;
            else {
                if (maxCnt > arr[i])
                    continue;
                else if (maxCnt == arr[i])
                    cnt.add(maxCnt);
                else {
                    maxCnt = arr[i];
                    answer = i;
                    cnt.clear();
                    cnt.add(maxCnt);
                }
            }
        }
        
        if (cnt.size() == 1)
            return answer;
        else
            return -1;
    }
}