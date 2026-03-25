import java.util.*;
import java.io.*;

public class Main {

    static int N, M, Q;
    static class Folder {
        String name;
        List<Folder> childFolders = new ArrayList<>();
        List<String> files = new ArrayList<>();

        Folder(String name) {
            this.name = name;
        }
    }

    static Map<String, Folder> folderMap = new HashMap<>();
    static int totalFileCount = 0;
    static Set<String> fileTypes = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); M = sc.nextInt();

        for (int i = 0; i < N + M; i++) {
            String p = sc.next();
            String c = sc.next();
            int isFolder = Integer.parseInt(sc.next());

            folderMap.putIfAbsent(p, new Folder(p));

            if (isFolder == 1) {
                folderMap.putIfAbsent(c, new Folder(c));
                folderMap.get(p).childFolders.add(folderMap.get(c));
            } else {
                folderMap.get(p).files.add(c);
            }
        }

        Q = sc.nextInt();
        while (Q-- > 0) {
            String query = sc.next();
            int lastSlash = query.lastIndexOf('/');
            int index = lastSlash < 0 ? 0 : lastSlash + 1;
            
            String name = query.substring(index);

            fileTypes.clear();
            totalFileCount = 0;

            search(folderMap.get(name));

            System.out.println(fileTypes.size() + " " + totalFileCount);
        }
    }

    static void search(Folder curr) {
        for (String filename : curr.files) {
            fileTypes.add(filename);
            totalFileCount++;
        }

        for (Folder next : curr.childFolders) {
            search(next);
        }
    }
}