import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int o = n;
        int count = 0;
        
        do {
            n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);
            count++;
        } while (o != n);
        
        System.out.println(count);
    }
}