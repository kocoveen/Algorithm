import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("(?=(?!^)\\.)(?<!\\.)|(?!\\.)(?<=\\.)");

        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            if (token.charAt(0) == '.') {
                sb.append(token);
            } else {
                if (token.length() % 2 != 0) {
                    System.out.println(-1);
                    System.exit(0);
                } else {
                    if (token.length() % 4 == 0) {
                        sb.append("A".repeat(token.length()));
                    } else {
                        sb.append("A".repeat(token.length() / 4 * 4));
                        sb.append("BB");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}