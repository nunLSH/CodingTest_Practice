class Solution {
    public String solution(String s) {
        int len = s.length();
        
        char[] str = new char[len];
        for (int i = 0; i < len; i++)
            str[i] = s.charAt(i);
            
        for (int i = 0; i < len; i++){
            if (i == 0){
                if (Character.isLetter(str[i]))
                    str[i] = Character.toUpperCase(str[i]);
            } else {
                if (str[i-1] == ' ' && Character.isLetter(str[i]))
                    str[i] = Character.toUpperCase(str[i]);
                else 
                    str[i] = Character.toLowerCase(str[i]);
            }
        }
        
        String answer = new String(str);
        return answer;
    }
}