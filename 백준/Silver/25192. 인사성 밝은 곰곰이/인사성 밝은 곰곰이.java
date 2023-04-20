import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, String> nick = new HashMap<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            String log = br.readLine();
            if (log.equals("ENTER")) {
                count += nick.size();
                nick.clear();
                continue;
            }
            if (!nick.containsKey(log))
                nick.put(log, log);
        }
        count += nick.size();
        System.out.println(count);
    }
}