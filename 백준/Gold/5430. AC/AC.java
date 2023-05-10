import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            String cmd = br.readLine(); int HT = 0;

            Deque<Integer> D = new ArrayDeque<>();
            int N = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split("\\D");

            for (int j = 1; j <= N; j++) {
                D.offerLast(Integer.valueOf(temp[j]));
            }

            Integer value = 1;
            for (int j = 0; j < cmd.length(); j++) {
                if (cmd.charAt(j) == 'R')
                    HT++;
                else {
                    if (HT % 2 == 0)
                        value = D.pollFirst();
                    else
                        value = D.pollLast();
                }
            }
            if (value == null) {
                sb.append("error").append("\n");
                continue;
            }

            sb.append("[");
            if (D.isEmpty()) {
                sb.append("]").append("\n");
                continue;
            }
            while (!D.isEmpty()) {
                if (HT % 2 == 0)
                    sb.append(D.pollFirst()).append(",");
                else
                    sb.append(D.pollLast()).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]").append("\n");
        }
        System.out.print(sb);
    }
}