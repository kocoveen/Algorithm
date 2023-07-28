import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static long N;
    static int P, Q;

    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Long.parseLong(line[0]);
        P = Integer.parseInt(line[1]);
        Q = Integer.parseInt(line[2]);

        map.put(0L, 1L);
        map.put(N, func(N));

        System.out.println(map.get(N));
    }

    private static long func(long i) {
        if (i == 0) return map.get(i);
        if (map.containsKey(i)) return map.get(i);
        map.put(i, func(i / P) + func(i / Q));
        return map.get(i);
    }
}