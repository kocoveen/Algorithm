import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String score = br.readLine();

        char score1 = score.charAt(0);
        
        if (score1 != 'F') {
            char score2 = score.charAt(1);

            float num = score2 == '+' ? 0.3f : -0.3f;
            if (score2 == '0') {
                num = 0;
            }
            System.out.println((float) 4 - (score1 - 'A') + num);
        } else {
            System.out.println(0.0);
        }
    }
}