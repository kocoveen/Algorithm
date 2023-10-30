import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();
        String explosion = br.readLine();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            s.push(c);

            while (s.size() >= explosion.length() && isExplosion(s, explosion)) {
                for (int j = 0; j < explosion.length(); j++) {
                    s.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (s.isEmpty()) {
            System.out.println("FRULA");
            System.exit(0);
        }

        for (char c : s) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    private static boolean isExplosion(Stack<Character> s, String explosion) {
        int idx = 0;
        for (int i = s.size() - explosion.length(); i < s.size(); i++, idx++) {
            if (s.get(i) != explosion.charAt(idx)) {
                return false;
            }
        }
        return true;
    }
}