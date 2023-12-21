import java.io.*;
import java.util.*;

public class Main {

    static Map<String, Integer> soldMap = new HashMap<>();
    static int n, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String book = br.readLine();
            soldMap.merge(book, 1, (oldV, newV) -> oldV + 1);
            max = Math.max(soldMap.get(book), max);
        }
        List<String> bookName = new ArrayList<>();
        for (Map.Entry<String, Integer> en : soldMap.entrySet()) {
            if (en.getValue() == max) {
                bookName.add(en.getKey());
            }
        }
        Collections.sort(bookName);
        System.out.println(bookName.get(0));
    }
}