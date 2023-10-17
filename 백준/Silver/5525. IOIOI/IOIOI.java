import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            sb.append('I').append('O');
        }
        String p = sb.append('I').toString();

        StringBuilder tmp = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (tmp.length() < 2 * n + 1) {
                tmp.append(c);
            }

            if (tmp.toString().equals(p)) {
                answer++;
            }

            if (tmp.length() >= 2 * n + 1) {
                tmp.deleteCharAt(0);
            }
        }
        System.out.println(answer);
    }
}