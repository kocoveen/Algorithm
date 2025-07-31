import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            char[] numbers = input.toCharArray();

            int m = numbers[12] - '0';
            int idx = 0;
            int sum = 0;
            
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] == '*') {
                    idx = i;
                    continue;
                }

                if (i % 2 == 0) {
                    sum += numbers[i] - '0';
                } else {
                    sum += (numbers[i] - '0') * 3;
                }
            }

            int result = 0;
            for (int i = 0; i < 10; i++) {
                int num = idx % 2 == 0 ? i : (i * 3);
                
                if ((10 - ((sum + num) % 10)) % 10 == m) {
                    result = i;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}