import java.util.*;
import java.util.stream.*;

public class Main {

    static int n;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        IntStream.rangeClosed(1, n).forEach(i -> {
            int pick = sc.nextInt();
            list.add(list.size() - pick, i);
        });

        list.forEach(i -> System.out.print(i + " "));
    }
}