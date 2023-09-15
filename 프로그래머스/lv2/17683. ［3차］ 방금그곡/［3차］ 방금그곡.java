import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {
    private static final String PATTERN = "([A-G]#?)";
    private static final String CODE = "C, C#, D, D#, E, F, F#, G, G#, A, A#, B";
    static Map<String, String> map = new HashMap<>();
    static Pattern regex = Pattern.compile(PATTERN);

    public String solution(String m, String[] musicinfos) {
        initMap(map);

        Spliter spliter = new Spliter();
        String origin = String.join("", spliter.splitNotes(m).stream()
                .map(note -> map.get(note))
                .collect(Collectors.toList()));

        List<Music> musics = Arrays.stream(musicinfos)
                .map(info -> info.split(","))
                .map(info -> new Music(info[0], info[1], info[2], info[3]))
                .collect(Collectors.toList());

        List<Music> matchList = musics.stream()
                .filter(music -> music.notes.contains(origin))
                .sorted(Comparator.comparingInt(music -> -music.playTime))
                .collect(Collectors.toList());

        if (matchList.isEmpty()) {
            return "(None)";
        }

        return matchList.get(0).name;
    }

    private void initMap(Map<String, String> map) {
        String[] codes = CODE.split(", ");
        map.put(codes[0], "C");
        map.put(codes[1], "H");
        map.put(codes[2], "D");
        map.put(codes[3], "I");
        map.put(codes[4], "E");
        map.put(codes[5], "F");
        map.put(codes[6], "J");
        map.put(codes[7], "G");
        map.put(codes[8], "K");
        map.put(codes[9], "A");
        map.put(codes[10], "L");
        map.put(codes[11], "B");
    }

    static class Music {
        int playTime;
        String name;
        String notes;

        public Music(String startTime, String endTime, String name, String notes) {
            this.playTime = timeToDigit(endTime) - timeToDigit(startTime);
            this.name = name;
            this.notes = extractedNotes(notes, playTime);
        }

        private String extractedNotes(String notes, int playTime) {
            Matcher matcher = regex.matcher(notes);

            List<String> noteList = matcher.results()
                    .map(MatchResult::group)
                    .map(code -> map.get(code))
                    .collect(Collectors.toList());

            List<String> newList = new ArrayList<>();
            int repeat = (playTime - 1) / noteList.size() + 1;
            for (int i = 0; i < repeat; i++) {
                newList.addAll(noteList);
            }

            return String.join("", newList.subList(0, playTime));
        }

        private int timeToDigit(String time) {
            String[] times = time.split(":");
            return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }
    }

    static class Spliter {
        public List<String> splitNotes(String notes) {
            Matcher matcher = regex.matcher(notes);

            return matcher.results()
                    .map(MatchResult::group)
                    .collect(Collectors.toList());
        }
    }
}