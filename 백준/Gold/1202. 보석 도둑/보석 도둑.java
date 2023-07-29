import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[] tokens;
    static String token;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Jewel> jewels = new ArrayList<>();
        NavigableMap<Integer, Integer> bags = new TreeMap<>();

        tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        k = Integer.parseInt(tokens[1]);

        while (n-- > 0) {
            tokens = br.readLine().split(" ");
            int weight = Integer.parseInt(tokens[0]);
            int value = Integer.parseInt(tokens[1]);
            jewels.add(new Jewel(weight, value));
        }
        Collections.sort(jewels, (j1, j2) -> j2.value - j1.value);

        while (k-- > 0) {
            int tolerance = Integer.parseInt(br.readLine());
            bags.put(tolerance, bags.getOrDefault(tolerance, 0) + 1);
        }

        long ans = 0L;
        for (Jewel jewel : jewels) {
            Integer fittedBagKey = bags.ceilingKey(jewel.weight);
            if (fittedBagKey == null) continue;
            ans += jewel.value;

            if (bags.get(fittedBagKey) == 1) {
                bags.remove(fittedBagKey);
            } else {
                bags.put(fittedBagKey, bags.get(fittedBagKey) - 1);
            }
        }

        System.out.println(ans);
    }

    private static class Jewel {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}