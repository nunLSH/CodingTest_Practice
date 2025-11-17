import java.util.*;
class Solution {
    public HashSet<Integer> set = new HashSet<>();
    boolean[] visited = new boolean[7];
    
    public boolean isPrimeNum(int number){
        if (number < 2) return false;
        
        for (int i = 2; i * i <= number; i++){
            if (number % i == 0) return false;
        }
        
        set.add(number);
        return true;
    }
    
    public void makeNumber(int selectedNum, int[] numbers){
        // 만들 수 있는 전체 수 구하기
        isPrimeNum(selectedNum);
        
        for (int i = 0 ; i < numbers.length; i++){
            if (visited[i] == false){
                visited[i] = true;
                
                int next = selectedNum * 10 + numbers[i];
                makeNumber(next, numbers);
                
                visited[i] = false;
            }
        }
        
        return;
    }
    
    public int solution(String numbers) {
        // 문자열 > 숫자 배열
        int len = numbers.length();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++)
            nums[i] = (int) (numbers.charAt(i) - '0');
        
        // 만들 수 있는 전체 수 구하기
        // 그 만든 수가 소수인지 확인하기
        for (int i = 0; i < len; i++){ // 시작 숫자
            if (nums[i] != 0){
                visited[i] = true;
                makeNumber(nums[i], nums);
                visited[i] = false;
            }
        }
        
        return set.size(); // 소수가 들어있는 set의 크기 반환
    }
}
