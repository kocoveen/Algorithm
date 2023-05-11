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
        for (int i = 0; i < VPS.length(); i++) {
            if (VPS.charAt(i) == '(')
                S.push('(');
            else {
                if (VPS.charAt(i - 1) == '(') {
                    S.pop();
                    sum += S.size();
                } else {
                    S.pop();
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}