import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static List<String> files = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            files.add(sc.next());
        }

        files.stream()
            .map(s -> s.substring(s.lastIndexOf(".") + 1))
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });
    }
}