import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Loop1:
        for (int i = 0; i < N; i++) {
            Stack<String> S = new Stack<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                String r = String.valueOf(s.charAt(j));
                if (r.equals("("))
                    S.push(r);
                else if (r.equals(")")) {
                    if (S.empty()) {
                        sb.append("NO").append("\n");
                        continue Loop1;
                    }
                    S.pop();
                }
            }
            if (!S.empty())
                sb.append("NO").append("\n");
            else
                sb.append("YES").append("\n");
        }

        System.out.print(sb);
    }

}