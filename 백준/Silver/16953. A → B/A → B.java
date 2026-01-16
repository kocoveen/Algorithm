import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int count = 1;
        while (A < B) { 
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break;
            }
            count++;
        }

        if (A == B) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}