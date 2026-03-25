import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = -1;

        for (int b5 = N / 5; b5 >= 0; b5--) {
            int remain = N - b5 * 5;
            if (remain % 3 == 0) {
                int b3 = remain / 3;
                ans = b5 + b3;
                break;
            }
        }

        System.out.println(ans);
    }
}