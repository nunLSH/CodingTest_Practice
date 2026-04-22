import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String bomb = br.readLine();
        
        StringBuilder sb = new StringBuilder();  
        int bombLen = bomb.length();
        for (char c : s.toCharArray()){
            sb.append(c);

            if (sb.length() >= bomb.length()){
                boolean match = true;

                for (int i = 0; i < bombLen; i++){
                    if (sb.charAt(sb.length() - bombLen + i) != bomb.charAt(i)){
                        match = false;
                        break;
                    }
                }

                if (match)
                    sb.delete(sb.length() - bombLen, sb.length());
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}