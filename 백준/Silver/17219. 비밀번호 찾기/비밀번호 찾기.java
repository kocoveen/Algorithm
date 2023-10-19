import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        Map<String, String> map = new HashMap<>();
        while (n-- > 0) {
            split = br.readLine().split(" ");
            map.put(split[0], split[1]);
        }

        while (m-- > 0) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}