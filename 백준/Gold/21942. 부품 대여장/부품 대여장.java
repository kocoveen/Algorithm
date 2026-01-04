import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");

        int N = Integer.parseInt(line[0]);

        String[] parts = line[1].split("\\W");
        int DDD = Integer.parseInt(parts[0]);
        int hh = Integer.parseInt(parts[1]);
        int mm = Integer.parseInt(parts[2]);
        Duration duration = Duration.ofDays(DDD).plusHours(hh).plusMinutes(mm);

        long F = Integer.parseInt(line[2]);

        Map<Transaction, LocalDateTime> txMap = new HashMap<>(); // transaction map
        TreeMap<String, Long> fineMap = new TreeMap<>(); // fine map

        while (N-- > 0) {
            String[] record = reader.readLine().split(" ");
            var datetime1 = getDateTime(record[0], record[1]);
            String product = record[2];
            String username = record[3];

            Transaction t1 = new Transaction(product, username);

            if (!txMap.containsKey(t1)) {
                txMap.put(t1, datetime1);
            } else {
                LocalDateTime borrowTime = txMap.remove(t1);

                Duration used = Duration.between(borrowTime, datetime1);
                Duration overdue = used.minus(duration);

                // overdue가 양수 이면,
                if (!overdue.isNegative() && !overdue.isZero()) {
                    long fine = overdue.toMinutes() * F;
                    fineMap.merge(username, fine, Long::sum);
                }
            }
        }

        if (fineMap.isEmpty()) {
           writer.write("-1"); 
        } else {
            for (var entry : fineMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        }
        writer.flush();
    }
 
    private static LocalDateTime getDateTime(String date, String time) {
        String[] dateParts = date.split("-");
        String[] timeParts = time.split(":");
        
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);

        return LocalDateTime.of(year, month, day, hour, minute);
    }

    static class Transaction {
        String product;
        String username;

        public Transaction(String product, String username) {
            this.product = product;
            this.username = username;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 83 * hash + Objects.hashCode(this.product);
            hash = 83 * hash + Objects.hashCode(this.username);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Transaction other = (Transaction) obj;
            if (!Objects.equals(this.product, other.product)) {
                return false;
            }
            return Objects.equals(this.username, other.username);
        }
    }
}