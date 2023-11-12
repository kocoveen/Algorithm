import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int mn = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            dq.offerLast(string.charAt(i));
        }

        for (int i = string.length(); i >= 0; i--) {
            Deque<Character> dq1 = new ArrayDeque<>(dq);
            for (int j = i - 1; j >= 0; j--) {
                dq1.offerLast(string.charAt(j));
            }

            if (isPalindrome(dq1)) {
                mn = Math.min(mn, dq1.size());
            }
        }

        System.out.println(mn);

    }

    private static boolean isPalindrome(Deque<Character> dq1) {
        Deque<Character> dq2 = new ArrayDeque<>(dq1);
        int count = dq2.size() / 2;
        for (int i = 0; i < count; i++) {
            char f = dq2.pollLast();
            char e = dq2.pollFirst();
            if (f != e) {
                return false;
            }
        }
        return true;
    }

}