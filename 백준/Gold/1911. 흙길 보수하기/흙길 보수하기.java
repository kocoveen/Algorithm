import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Info {
        int l, r;
        public Info(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static int N, L, cnt, tmp;
    static List<Info> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = read(); L = read();

        for (int i = 0; i < N; i++) {
            int l = read();
            int r = read();
            list.add(new Info(l, r));
        }

        list.sort((i1, i2) -> Integer.compare(i1.l, i2.l));

        for (Info i : list) {
            if (tmp > i.r) continue;
            else if (tmp > i.l) i.l = tmp;

            int len = i.r - i.l;
            int tmpCnt = (len / L) + (len % L == 0 ? 0 : 1);
            cnt += tmpCnt;
            tmp = L * tmpCnt + i.l;
        }
        System.out.println(cnt);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}