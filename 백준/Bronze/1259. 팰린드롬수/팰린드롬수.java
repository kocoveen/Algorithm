import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            String a = br.readLine();
            boolean ok = true;
            if (a.equals("0"))
                System.exit(0);

            for (int i = 0; i < a.length() / 2; i++) {
                if (a.charAt(i) != a.charAt(a.length() - i - 1)) {
                    ok = false;
                    break;
                }
            }

            if (ok)
                System.out.println("yes");
            else
                System.out.println("no");
        }

    }
}