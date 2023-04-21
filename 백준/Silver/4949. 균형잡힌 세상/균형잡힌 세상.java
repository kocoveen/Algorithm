import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        Loop1:
        while (true) {
            Stack<String> S = new Stack<>();
            String s = br.readLine();
            if (s.equals("."))
                break;
            for (int j = 0; j < s.length(); j++) {
                String r = String.valueOf(s.charAt(j));
                if (r.equals("(") ||  r.equals("["))
                    S.push(r);
                else if (r.equals(")") || r.equals("]")) {
                    if (S.empty()) {
                        sb.append("no").append("\n");
                        continue Loop1;
                    }
                    if (S.peek().equals("(") && r.equals(")"))
                        S.pop();
                    else if (S.peek().equals("[") && r.equals("]"))
                        S.pop();
                    else {
                        sb.append("no").append("\n");
                        continue Loop1;
                    }
                }
            }
            if (!S.empty())
                sb.append("no").append("\n");
            else
                sb.append("yes").append("\n");
        }
        System.out.print(sb);
    }
}