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

        Stack<Integer> S = new Stack<>();

        int n = 1; int pushCount = 0; int popCount = 0;
        while (N > 0) {
            int a = Integer.parseInt(br.readLine());
            while (n <= a) {
                S.push(n++);
                pushCount++;
                sb.append("+").append("\n");
            }

            if (S.peek() == a) {
                S.pop();
                popCount++;
                sb.append("-").append("\n");
            }
            N--;
        }

        if (pushCount == popCount)
            System.out.print(sb);
        else
            System.out.println("NO");
    }
}