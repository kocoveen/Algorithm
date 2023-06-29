import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        l = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(l[i]);
        }
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        l = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(l[i]);
            sb.append(binarySearch(cards, target)).append(' ');
        }
        System.out.println(sb);

    }

    private static long binarySearch(int[] cards, int target) {
        int l = 0, r = cards.length, m = (l + r) / 2;
        while (l < r) {
            if (target == cards[m]) return 1;
            else if (cards[m] < target) l = m + 1;
            else r = m;
            m = (l + r) / 2;
        }
        return 0;
    }
}