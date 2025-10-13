class Solution {
    public StringBuffer binaryNum(int num) {
        StringBuffer sb = new StringBuffer();
        
        while (num > 0){
            sb.append(Integer.toString(num % 2));
            num /= 2;
        }
        
        return sb.reverse();
    }
    
    public int[] solution(String s) {
        StringBuffer sb = new StringBuffer(s);
        
        int[] answer = {0, 0};
        while (!sb.toString().equals("1")){
            // 제거할 0의 개수
            for (int i = 0; i < sb.length(); i++){
                if (sb.charAt(i) == '0')
                    answer[1]++;
            }
            
            String ss = sb.toString().replace("0", "");
            
            // 길이를 이진법으로 변환
            int len = ss.length();
            sb = binaryNum(len);
            answer[0]++;
        }
        
        return answer;
    }
}