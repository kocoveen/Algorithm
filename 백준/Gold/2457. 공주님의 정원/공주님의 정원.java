import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String[] l;

    static int N;

    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] days;
    static List<D> F = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        days = new int[13];
        for (int i = 1; i <= 12; i++) days[i] = days[i - 1] + month[i];

        for (int i = 0; i < N; i++) {
            l = br.readLine().split(" ");
            int sM = Integer.parseInt(l[0]);
            int sD = Integer.parseInt(l[1]);
            int eM = Integer.parseInt(l[2]);
            int eD = Integer.parseInt(l[3]);
            F.add(new D(days[sM - 1] + sD, days[eM - 1] + eD));
        }

        int t = days[2] + 1;
        int ans = 0;
        while (t < days[11] + 1) {

            int max = 0;
            for (D d : F)
                if (d.sDate <= t && t < d.eDate)
                    max = Math.max(max, d.eDate);
            int next_t = max;

            if(next_t == t) {
                System.out.println(0);
                System.exit(0);
            }
            ans++;
            t = next_t;
        }
        System.out.println(ans);
    }

    private static class D {
        int sDate;
        int eDate;

        public D(int sDate, int eDate) {
            this.sDate = sDate;
            this.eDate = eDate;
        }
    }
}