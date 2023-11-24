import java.io.*;
import java.util.regex.Pattern;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String regex = "[ABCDEF]?A+F+C+[ABCDEF]?";
        
        while (n-- > 0) {
            String str = br.readLine();
            if (Pattern.matches(regex, str)) {
                sb.append("Infected!");
            } else {
                sb.append("Good");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}