import java.io.IOException;

public class Main {

    static int n, m;
    static int brokens;

    public static void main(String[] args) throws IOException {
        n = read();
        m = read();
        for (int i = 0; i < m; i++) {
            brokens |= 1 << read();
        }

        int min = Math.abs(n - 100);
        for (int i = 0; i <= 999999; i++) {
            String channel = Integer.toString(i);

            boolean isBroken = false;
            for (int j = 0; j < channel.length(); j++) {
                int button = channel.charAt(j) - '0';
                if ((brokens & (1 << button)) == (1 << button)) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int cnt = channel.length() + Math.abs(n - i);
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
    }

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
