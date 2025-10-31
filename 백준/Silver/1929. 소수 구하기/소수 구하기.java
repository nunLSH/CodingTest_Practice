import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        for (int i = m; i <= n; i++){
            if (isPrime(i))
                System.out.println(i);
        }
    }
    
    public static boolean isPrime(int num){
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}