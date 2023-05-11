import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Loop1 :
        for (int j = 0; j < T; j++) {

            String s = br.readLine();

            Stack<Character> S = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(')
                    S.push(c);
                else if (c == ')') {
                    if (S.isEmpty()) {
                        sb.append("NO").append("\n");
                        continue Loop1;
                    }

                    if (S.peek() == '(')
                        S.pop();
                }
            }
            if (S.isEmpty())
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }
}