import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set S = new Set();
        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            String op = command[0];
            int x = 0;
            if (command.length == 2) {
                x = Integer.parseInt(command[1]);
            }

            switch (op) {
                case "add": {
                    S.add(x);
                    break;
                }
                case "remove": {
                    S.remove(x);
                    break;
                }
                case "check": {
                    bw.write(S.check(x) + "\n");
                    break;
                }
                case "toggle": {
                    S.toggle(x);
                    break;
                }
                case "all": {
                    S.all();
                    break;
                }
                case "empty": {
                    S.empty();
                    break;
                }
            }
        }
        bw.flush();
    }

    static class Set {
        int set;

        public Set() {
            this.set = 0;
        }

        public void add(int x) {
            set |= (1 << x);
        }

        public void remove(int x) {
            set &= ~(1 << x);
        }

        public int check(int x) {
            return (set & (1 << x)) > 0 ? 1 : 0 ;
        }

        public void toggle(int x) {
            set ^= (1 << x);
        }

        public void all() {
            set = (1 << 21) - 1;
        }

        public void empty() {
            set = 0;
        }
    }
}
