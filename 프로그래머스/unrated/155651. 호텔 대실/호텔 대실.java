import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        List<Reservation> reservations = new ArrayList<>();
        for (String[] book : book_time) {
            reservations.add(new Reservation(book));
        }
        reservations.sort(Comparator.comparingInt(r -> r.start_time));

        List<Stack<Reservation>> rent = new ArrayList<>();

        for (Reservation r : reservations) {
            if (rent.isEmpty()) {
                rent.add(new Stack<>());
            }

            boolean flag = false;
            for (Stack<Reservation> room : rent) {
                if (room.isEmpty() || r.start_time >= room.peek().end_time) {
                    room.push(r);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                Stack<Reservation> S = new Stack<>();
                S.push(r);
                rent.add(S);
            }
        }

        return rent.size();
    }

    static class Reservation {
        int start_time;
        int end_time;

        public Reservation (String[] book_time) {
            this.start_time = timeToDigit(book_time[0]);
            this.end_time = timeToDigit(book_time[1]) + 10;
        }

        private int timeToDigit(String time) {
            String[] splits = time.split(":");
            return Integer.parseInt(splits[0]) * 60 + Integer.parseInt(splits[1]);
        }

    }
}