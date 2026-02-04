import java.util.*;
public class Main {
    static boolean[] virus; // 방문(바이러스) 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nums = sc.nextInt(); // 컴퓨터의 수
        int pair = sc.nextInt(); // 컴퓨터 쌍의 수

        virus = new boolean[nums+1];
        List<Integer>[] com = new ArrayList[nums + 1];
    
        for (int i = 1; i <= nums; i++)
            com[i] = new ArrayList<>();

        for (int i = 0; i < pair; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            com[a].add(b);
            com[b].add(a);
        }

        int answer = 0;
        
        dfs(1, com);

        for (int i = 2; i <= nums; i++){ // 1번 컴퓨터 제외
            if (virus[i] == true)
                answer++;
        }

        System.out.println(answer);
    }

    public static void dfs(int cur, List<Integer>[] com){
        virus[cur] = true;

        for (int i = 0; i < com[cur].size(); i++){
            if (virus[com[cur].get(i)] == false)
                dfs(com[cur].get(i), com);
        }
    }
}