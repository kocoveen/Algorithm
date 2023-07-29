import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[] line;
    static int n, q, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        q = Integer.parseInt(line[1]);

        NavigableMap<Integer, Integer> hotPlaces = new TreeMap<>();
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int hot = Integer.parseInt(line[i]);
            if (hot == 1) {
                hotPlaces.put(i, 1);
            }
        }
        while (q-- > 0) {
            line = br.readLine().split(" ");
            switch (line[0]) {
                case "1": {
                    int place = Integer.parseInt(line[1]) - 1;
                    if (!hotPlaces.containsKey(place)) {
                        hotPlaces.put(place, 1);
                    } else {
                        hotPlaces.remove(place);
                    }
                    break;
                }
                case "2": {
                    int move = Integer.parseInt(line[1]);
                    x = (move + x) % n;
                    break;
                }
                default: {
                    if (hotPlaces.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    Integer dist = hotPlaces.ceilingKey(x);
                    if (dist == null) {
                        dist = hotPlaces.ceilingKey(0) + (n - x);
                    } else {
                        dist -= x;
                    }
                    sb.append(dist).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}