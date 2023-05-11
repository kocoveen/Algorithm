import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String VPS = br.readLine();
        Stack<Character> S = new Stack<>();

        int sum = 0;
        int num = 1;
        for (int i = 0; i < VPS.length(); i++) {
            char c = VPS.charAt(i);

            if (c == '(') {
                num *= 2;
                S.push(c);
            } else if (c == '[') {
                num *= 3;
                S.push(c);
            } else if (c == ')') {
                if (S.isEmpty() || S.peek() != '(') {
                    System.out.println(0);
                    System.exit(0);
                }

                if (VPS.charAt(i - 1) == '(') sum += num;
                S.pop();
                num /= 2;
            } else {
                if (S.isEmpty() || S.peek() != '[') {
                    System.out.println(0);
                    System.exit(0);
                }

                if (VPS.charAt(i - 1) == '[') sum += num;
                S.pop();
                num /= 3;
            }
        }

        if (S.isEmpty()) System.out.println(sum);
        else System.out.println(0);

    }
}