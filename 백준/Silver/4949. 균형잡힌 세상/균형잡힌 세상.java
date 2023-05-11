import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Loop1 :
        while (true) {
            String s = br.readLine();
            if (s.equals("."))
                break;

            Stack<Character> S = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[')
                    S.push(c);
                else if (c == ')' || c == ']') {
                    if (S.isEmpty()) {
                        sb.append("no").append("\n");
                        continue Loop1;
                    }
                    
                    if (S.peek() == '(' && c == ')')
                        S.pop();
                    else if (S.peek() == '[' && c == ']')
                        S.pop();
                    else {
                        sb.append("no").append("\n");
                        continue Loop1;
                    }
                }
            }
            if (S.isEmpty())
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }

        System.out.print(sb);
    }
}