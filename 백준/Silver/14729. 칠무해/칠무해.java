import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    static TreeMap<Double, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (n-- > 0) {
            double score = Double.parseDouble(br.readLine());
            map.put(score, map.getOrDefault(score, 0) + 1);
            cnt++;

            if (cnt > 7) {
                Double d = map.lastKey();
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0) {
                    map.remove(d);
                }
            }
        }

        for (Map.Entry<Double, Integer> en : map.entrySet()) {
            for (int i = 0; i < en.getValue(); i++) {
                System.out.printf("%.3f\n" , en.getKey());
            }
        }
    }
}