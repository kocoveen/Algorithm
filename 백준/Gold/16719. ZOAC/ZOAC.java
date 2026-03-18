import java.util.*;

public class Main {

    static char[] str;
    static boolean[] visit;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        str = sc.next().toCharArray();
        visit = new boolean[str.length];
        
        find(0, str.length - 1);
        
        System.out.println(result);
    }

    public static void find(int l, int r) {
        if (l > r) return;

        int minIdx = l;
        for (int i = l; i <= r; i++) {
            if (str[minIdx] > str[i]) {
                minIdx = i;
            }
        }

        visit[minIdx] = true;
        for (int i = 0; i < str.length; i++) {
            if (visit[i]) {
                result.append(str[i]);
            }
        }

        result.append("\n");

        // -----
        find(minIdx+1, r);
        find(l, minIdx-1);
    }
}