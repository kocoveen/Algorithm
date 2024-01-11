import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] brackets = br.readLine().toCharArray();
        List<Character> l = new ArrayList<>();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < brackets.length; i++) {
            char c = brackets[i];
            if (c == '(') {
                int j = i;
                s.push(brackets[j]);
                j++;
                while (!s.isEmpty() && j < brackets.length) {
                    if (brackets[j] == ')') {
                        s.pop();
                    } else {
                        s.push(brackets[j]);
                    }
                    j++;
                }
                while (!s.isEmpty()) {
                    l.add(s.pop());
                }
                i = j - 1;
            } else {
                l.add(c);
            }
        }

        System.out.println(l.size());
    }
}