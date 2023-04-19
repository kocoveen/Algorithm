import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        sb.append((int) Math.floor(Math.sqrt(N)));
        bw.write( sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}