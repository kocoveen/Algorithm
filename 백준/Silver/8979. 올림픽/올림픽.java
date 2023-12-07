import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Nation> nations = new ArrayList<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            nations.add(new Nation(number, gold, silver, bronze));
        }

        nations.sort((n1, n2) -> {
            if (n1.gold != n2.gold) {
                return n2.gold - n1.gold;
            } else if (n1.silver != n2.silver) {
                return n2.silver - n1.silver;
            } else if (n1.bronze != n2.bronze) {
                return n2.bronze - n1.bronze;
            } else {
                return n1.number - n2.number;
            }
        });

        Map<Integer, Nation> rank = new HashMap<>();
        int i = 1; int cnt = 0; int prevNum = 0;
        for (Nation cur : nations) {
            if (prevNum != 0) {
                Nation prev = rank.get(prevNum);
                if (prev.gold != cur.gold || prev.silver != cur.silver || prev.bronze != cur.bronze) {
                    i += cnt;
                    cnt = 0;
                }
            }
            cur.rank = i;
            cnt++;
            rank.put(cur.number, cur);
            prevNum = cur.number;
        }
        bw.write(rank.get(k).rank + "");
        bw.close();
    }

    private static class Nation {
        int number;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Nation(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}