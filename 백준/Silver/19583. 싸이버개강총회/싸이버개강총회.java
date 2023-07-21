import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] time = br.readLine().split(" ");
        int startTime = hourToMinute(time[0]);
        int endTime = hourToMinute(time[1]);
        int streamingTime = hourToMinute(time[2]);

        Map<String, Integer> enterMap = new HashMap<>();
        int a = 0;

        while (br.ready()) {
            String[] row = br.readLine().split(" ");
            int minuteTime = hourToMinute(row[0]);
            String name = row[1];

            if (minuteTime <= startTime) {
                enterMap.put(name, minuteTime);
                continue;
            }

            if (endTime <= minuteTime && minuteTime <= streamingTime) {
                if (enterMap.containsKey(name)) {
                    enterMap.remove(name);
                    a++;
                }
            }
        }
        System.out.println(a);
    }

    private static int hourToMinute(String s) {
        String[] HM = s.split(":");
        return Integer.parseInt(HM[0]) * 60 + Integer.parseInt(HM[1]);
    }
}