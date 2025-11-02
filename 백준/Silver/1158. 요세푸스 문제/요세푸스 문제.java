import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 원순열을 구성
        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            circle.add(i);

        // k번째를 제거 후 출력
        System.out.print("<");
        int idx = k - 1;
        while(circle.size() > 0){
            if (circle.size() == 1){
                System.out.print(circle.getFirst());
                break;
            }
                
            System.out.print(circle.get(idx) + ", ");
            circle.remove(idx);
            for (int i = 0; i < k - 1; i++){
                idx++;
                if (idx >= circle.size())
                    idx = idx - circle.size();
            }
        }

        System.out.print(">");
    }
}