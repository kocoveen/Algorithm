import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 8진수 숫자를 2진수 3자리로 미리 매핑 (룩업 테이블)
        String[] binaryMap = {"000", "001", "010", "011", "100", "101", "110", "111"};
        
        String s = sc.next();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            
            if (i == 0) {
                sb.append(Integer.toBinaryString(n));
            } else {
                sb.append(binaryMap[n]);
            }
        }

        System.out.println(sb.toString());
    }
}