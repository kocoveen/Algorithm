import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Double> table = new HashMap<>();
        table.put("A+", 4.5);
        table.put("A0", 4.0);
        table.put("B+", 3.5);
        table.put("B0", 3.0);
        table.put("C+", 2.5);
        table.put("C0", 2.0);
        table.put("D+", 1.5);
        table.put("D0", 1.0);
        table.put("F", 0.0);

        double total = 0; double sum = 0;
        for (int i = 0; i < 20; i++) {
            String bits[] = br.readLine().split(" ");
            if (!table.containsKey(bits[2]))
                continue;
            double credit = Double.parseDouble(bits[1]);
            double score = table.get(bits[2]);
            total += credit * score;
            sum += credit;
        }
        double result = total / sum;
        bw.write(String.format("%.6f", result));

        br.close();
        bw.flush();
        bw.close();
    }
}