import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int n, m, x, y;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        n = read();
        visit = new boolean[n+1];

        List<Member> family = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            family.add(new Member(i));
        }

        x = read(); y = read();
        m = read();
        while (m-- > 0) {
            int p = read();
            int c = read();
            family.get(c).addMember(family.get(p));
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(family.get(x).n, 0));
        visit[x] = true;
        while (!q.isEmpty()) {
            Info i = q.poll();
            int c = i.c;

            for (Member m : family.get(i.n).members) {
                if (visit[m.n]) continue;
                if (m.n == y) {
                    System.out.println(c + 1);
                    System.exit(0);
                }
                q.add(new Info(m.n, c + 1));
                visit[m.n] = true;
            }
        }
        System.out.println(-1);
    }

    static class Info {
        int n;
        int c;

        public Info(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }

    static class Member {
        int n;
        List<Member> members = new ArrayList<>();

        public Member(int n) {
            this.n = n;
        }

        public void addMember(Member member) {
            this.members.add(member);
            member.members.add(this);
        }
    }

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read(); // c == '\r' -> '\n'. for CRLF(Windows)
        return n;
    }
}