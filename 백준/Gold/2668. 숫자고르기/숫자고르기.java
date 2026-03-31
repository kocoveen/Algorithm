import java.util.*;

public class Main {
    
    static int N;
    static int[] table;
    static boolean[] visit;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        table = new int[N+1];
        visit = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            table[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;            
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    private static void dfs(int s, int i) {
        if (!visit[table[s]]) {
            visit[table[s]] = true;
            dfs(table[s], i);
            visit[table[s]] = false;
        }

        if (table[s] == i) {
            result.add(i);
        }
    }
}