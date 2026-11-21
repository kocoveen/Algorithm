import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int m = sc.nextInt();

        WaitingQueue waitingQueue = new WaitingQueue(m);

        for (int i = 0; i < p; i++) {
            int level = sc.nextInt();
            String name = sc.next();
            waitingQueue.enter(new User(level, name));
        }

        for (Room room : waitingQueue.getRooms()) {
            System.out.println(room.getStatus());
            for (User user : room.getSortedUsers()) {
                System.out.println(user);
            }
        }
    }

    static class WaitingQueue {
        private final List<Room> rooms = new ArrayList<>();
        private final int roomCapacity;

        public WaitingQueue(int roomCapacity) {
            this.roomCapacity = roomCapacity;
        }

        public void enter(User user) {
            for (Room room : rooms) {
                if (room.tryJoin(user)) {
                    return;
                }
            }
            rooms.add(new Room(roomCapacity, user));
        }

        public List<Room> getRooms() {
            return Collections.unmodifiableList(rooms);
        }
    }

    static class Room {
        private static final int LEVEL_RANGE = 10;

        private final List<User> users = new ArrayList<>();
        private final int capacity;
        private final int minLevel;
        private final int maxLevel;

        public Room(int capacity, User host) {
            this.capacity = capacity;
            this.minLevel = host.getLevel() - LEVEL_RANGE;
            this.maxLevel = host.getLevel() + LEVEL_RANGE;
            this.users.add(host);
        }

        public boolean tryJoin(User user) {
            if (isFull() || !user.isLevelWithin(minLevel, maxLevel)) {
                return false;
            }
            return users.add(user);
        }

        public boolean isFull() {
            return users.size() == capacity;
        }

        public String getStatus() {
            return isFull() ? "Started!" : "Waiting!";
        }

        public List<User> getSortedUsers() {
            List<User> sorted = new ArrayList<>(users);
            Collections.sort(sorted);
            return sorted;
        }
    }

    static class User implements Comparable<User> {
        private final int level;
        private final String name;

        public User(int level, String name) {
            this.level = level;
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public boolean isLevelWithin(int min, int max) {
            return min <= level && level <= max;
        }

        @Override
        public int compareTo(User other) {
            return this.name.compareTo(other.name);
        }

        @Override
        public String toString() {
            return level + " " + name;
        }
    }
}