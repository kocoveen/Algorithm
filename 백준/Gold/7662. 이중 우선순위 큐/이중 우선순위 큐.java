import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, k;
    static TreeMap<Integer, Integer> tm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            k = Integer.parseInt(br.readLine());
            tm = new TreeMap<>();

            while (k-- > 0) {
                String[] cmdLine = br.readLine().split(" ");
                String cmd = cmdLine[0];
                int param = Integer.parseInt(cmdLine[1]);

                if (cmd.equals("D")) {
                    if (tm.isEmpty()) continue;
                    if (param == -1) {
                        int minKey = tm.firstKey();
                        if (tm.get(minKey) == 1) {
                            tm.remove(minKey);
                        } else {
                            tm.put(minKey, tm.get(minKey) - 1);
                        }
                    } else {
                        int maxKey = tm.lastKey();
                        if (tm.get(maxKey) == 1) {
                            tm.remove(maxKey);
                        } else {
                            tm.put(maxKey, tm.get(maxKey) - 1);
                        }
                    }
                } else {
                    tm.put(param, tm.getOrDefault(param, 0) + 1);
                }
            }

            if (tm.isEmpty()) {
                sb.append("EMPTY").append("\n");
                continue;
            }
            sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
        }

        System.out.print(sb);

    }
}