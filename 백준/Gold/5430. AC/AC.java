import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int t, n;
    static Deque<Integer> d;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        Loop: while (t-- > 0) {
            String func = br.readLine();
            n = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split("\\W");
            d = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                d.add(Integer.parseInt(split[i]));
            }
            int c = 0;
            for (int i = 0; i < func.length(); i++) {
                if (func.charAt(i) == 'R') {
                    c++;
                } else {
                    if (d.isEmpty()) {
                        sb.append("error").append("\n");
                        continue Loop;
                    } else {
                        if (c % 2 == 0) {
                            d.removeFirst();
                        } else {
                            d.removeLast();
                        }
                    }
                }
            }

            sb.append("[");
            while (!d.isEmpty()) {
                int i = c % 2 == 0 ? d.removeFirst() : d.removeLast();
                sb.append(i).append(',');
            }
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]\n");
        }
        System.out.print(sb);
    }
}