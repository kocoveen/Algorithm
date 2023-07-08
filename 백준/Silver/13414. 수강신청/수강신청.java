import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static String[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = br.readLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);

        Map<String, Integer> M = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String st = br.readLine();
            M.put(st, i);
        }

        List<Pair> L = new ArrayList<>();
        for (Map.Entry<String, Integer> en : M.entrySet())
            L.add(new Pair(en.getKey(), en.getValue()));

        Collections.sort(L, (i1, i2) -> i1.num - i2.num);

        for (int i = 0; i < Math.min(k, L.size()); i++)
            sb.append(L.get(i).s_num).append('\n');
        System.out.print(sb);
    }

    private static class Pair {
        String s_num;
        int num;

        public Pair(String s_num, int num) {
            this.s_num = s_num;
            this.num = num;
        }
    }
}