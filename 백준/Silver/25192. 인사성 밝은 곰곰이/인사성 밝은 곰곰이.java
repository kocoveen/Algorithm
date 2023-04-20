import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> nick = new HashSet<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            String log = br.readLine();
            if (log.equals("ENTER")) {
                nick.clear();
                continue;
            }
            if(!nick.contains(log))
                count++;
            nick.add(log);
        }
        System.out.println(count);
    }
}