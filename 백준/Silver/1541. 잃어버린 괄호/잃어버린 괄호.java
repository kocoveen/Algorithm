import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = reader.readLine().split("(?=\\D)|(?<=\\D)");

        // IO.println(Arrays.toString(exp));

        int totalSum = 0;
        int subSum = 0;
        for (int i = exp.length - 2; i >= 1; i -= 2) {
            if (Objects.equals(exp[i], "+")) {
                subSum += Integer.parseInt(exp[i+1]);
            } else if (Objects.equals(exp[i], "-")) {
                totalSum -= Integer.parseInt(exp[i+1]) + subSum;
                subSum = 0;
            }
        }

        System.out.print(totalSum + Integer.parseInt(exp[0]) + subSum);
    }
}