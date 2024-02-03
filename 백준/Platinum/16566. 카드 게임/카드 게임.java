import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String[] line;
    static int n, m, k; // n = 1~n 개의 카드, m = 민수가 가진 카드 수, k = 라운드 수
    static int[] deck1; // 민수가 가진 카드
    static int[] deck2; // 철수가 낼 카드 목록
    static int[] arr; // 민수가 뽑을 카드의 인덱스
    // deck1의 해당 인덱스의 카드를 뽑을 수 있음 -> arr[value] = 자신의 인덱스
    // deck1의 해당 인덱스의 카드를 뽑을 수 없음 -> arr[value] = value + 1

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);

        deck1 = new int[m];
        line = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            deck1[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(deck1);

        deck2 = new int[k];
        line = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            deck2[i] = Integer.parseInt(line[i]);
        }

        arr = new int[m + 1];
        for (int i = 0; i < m; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < k; i++) {
            int idx = upperBound(deck1, deck2[i]);
            int fin = find(arr, idx);
            sb.append(deck1[fin]).append("\n");
            union(arr, fin, fin + 1);
        }
        System.out.print(sb);
    }

    private static int upperBound(int[] deck, int target) {
        int l = 0, r = deck.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (deck[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }

    private static int find(int[] arr, int u) {
        if (u == arr[u]) return u;
        return arr[u] = find(arr, arr[u]);
    }

    private static void union(int[] arr, int u, int v) {
        // v = u + 1
        u = find(arr, u);
        v = find(arr, v);
        if (u == v) return;
        arr[u] = v;
    }
}