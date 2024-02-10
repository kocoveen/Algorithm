import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
            if (stack.size() >= pattern.length() && isCorrect(stack, pattern)) {
                for (int j = 0; j < pattern.length(); j++) stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) sb.append("FRULA");
        else for (char c : stack) sb.append(c);
        System.out.println(sb);
    }

    private static boolean isCorrect(Stack<Character> stack, String pattern) {
        int si = stack.size() - pattern.length();
        for (int pi = 0; pi < pattern.length(); pi++) {
            if (stack.get(si + pi) != pattern.charAt(pi)) return false;
        }
        return true;
    }
}