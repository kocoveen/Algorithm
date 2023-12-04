import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        str = str.replaceAll("XXXX", "AAAA");
        str = str.replaceAll("XX", "BB");

        if (str.contains("X")) {
            sb.append("-1");
        } else {
            sb.append(str);
        }

        bw.write(sb.toString());
        bw.close();
    }
}