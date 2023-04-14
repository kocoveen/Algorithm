import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String dial[] = new String[9];
        dial[0] = "";
        dial[1] = "ABC";
        dial[2] = "DEF";
        dial[3] = "GHI";
        dial[4] = "JKL";
        dial[5] = "MNO";
        dial[6] = "PQRS";
        dial[7] = "TUV";
        dial[8] = "WYXZ";

        String a = st.nextToken();

        char str[] = a.toCharArray(); int sum = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 1; j < dial.length; j++) {
                if(dial[j].contains(String.valueOf(str[i])))
                    sum += j+2;
            }
        }
        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}