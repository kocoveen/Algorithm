import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] s = sc.next().toCharArray();
        int[] p = new int[m];
        int answer = 0;

        for (int i = 0; i < s.length; i++) {
            if (i < 2) {
                p[i] = s[i] == 'I' ? 0 : -1;
            } else {
                if (s[i] == 'I') {
                    if (s[i - 1] == 'O' && s[i - 2] == 'I') {
                        p[i] = p[i - 2] + 1;
                    } else {
                        p[i] = 0;
                    }
                } else {
                    p[i] = -1;
                }
            }
        }

        for (int c : p) {
            if (c >= n) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}