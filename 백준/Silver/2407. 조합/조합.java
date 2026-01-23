import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(combination(n, m));

    }

    private static BigInteger combination(int n, int m) {
        BigInteger numerator = IntStream.rangeClosed(n - m + 1, n)
                                        .mapToObj(i -> BigInteger.valueOf(i))
                                        .reduce(BigInteger.ONE, (subtotal, element) -> subtotal.multiply(element)); 
        BigInteger denominator = IntStream.rangeClosed(1, m)
                                        .mapToObj(i -> BigInteger.valueOf(i))
                                        .reduce(BigInteger.ONE, (subtotal, element) -> subtotal.multiply(element)); 

        return numerator.divide(denominator);
    }
}