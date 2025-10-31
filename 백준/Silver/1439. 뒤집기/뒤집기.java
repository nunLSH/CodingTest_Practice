import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        char c = s.charAt(0);
        boolean isChange = false;
        int cnt1 = 1, cnt2 = 0;
        for (int i = 1; i < s.length(); i++){
            if (c != s.charAt(i)){
                isChange = !isChange;
                c = s.charAt(i);
                if (isChange)
                    cnt2++;
                else 
                    cnt1++;
            }
        }
        
        System.out.print(Math.min(cnt1, cnt2));
    }
}