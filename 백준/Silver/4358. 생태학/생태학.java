import java.io.*;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> trees = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        String treeName;
        while ((treeName = br.readLine()) != null && !treeName.isEmpty()) {
            trees.merge(treeName, 1, Integer::sum);
        }

        int sum = trees.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        trees.forEach((k, v) ->
                sb.append(k)
                    .append(" ")
                    .append(String.format("%.4f", (double) v / sum * 100))
                    .append("\n"));

        System.out.print(sb);
    }
}