import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] binaryMap = {"000", "001", "010", "011", "100", "101", "110", "111"};
        
        char[] number = sc.next().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length; i++) {
            int n = number[i] - '0';
            
            if (i == 0) {
                sb.append(Integer.toBinaryString(n));
            } else {
                sb.append(binaryMap[n]);
            }
        }

        System.out.println(sb.toString());
    }
}