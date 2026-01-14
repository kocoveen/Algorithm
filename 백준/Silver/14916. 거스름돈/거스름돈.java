import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        
        int count = 0;
        while (a > 0) { 
            if (a <= 8) {
                switch (a) {
                    case 8 -> count += 4;
                    case 7 -> count += 2;
                    case 6 -> count += 3;
                    case 5 -> count += 1;
                    case 4 -> count += 2;
                    case 2 -> count += 1;
                    case 3, 1 -> {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
                break;
            } else {
                a -= 5;
                count++;
            }
        }
        System.out.println(count);
    }

}