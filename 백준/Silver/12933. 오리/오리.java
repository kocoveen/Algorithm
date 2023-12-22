import java.io.*;

public class Main {
    static char[] ducks = new char[500];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            func(c);
        }

        for (int i = 0; i < idx; i++) {
            if (ducks[i] != 'k') {
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(idx);
    }

    private static void func(char c) {
        if (idx == 0) {
            if (c == 'q') {
                ducks[idx++] = c;
                return;
            } else {
                System.out.println(-1);
                System.exit(0);
            }
        }

        switch (c) {
            case 'q': find('k', c); break;
            case 'u': find('q', c); break;
            case 'a': find('u', c); break;
            case 'c': find('a', c); break;
            case 'k': find('c', c); break;
        }
    }

    private static void find(char c, char a) {
        int i;
        for (i = 0; i < idx; i++) {
            if (ducks[i] == c) {
                ducks[i] = a;
                return;
            }
        }

        if (a == 'q') {
            ducks[idx++] = a;
        } else {
            System.out.println(-1);
            System.exit(0);
        }
    }
}