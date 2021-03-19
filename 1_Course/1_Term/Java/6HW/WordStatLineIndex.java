import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class WordStatLineIndex {
    public static void main(String[] args) throws IOException {
        MyScanner scan;
        LinkedHashMap<String, LinkedList<Integer>> words = new LinkedHashMap<>();
        try {
            scan = new MyScanner(new File(args[0]));
            try {
                String str;
                int pos[] = {1, 1};
                while (!scan.hasNotNextword()) {
                    str = scan.nextLine();
                    if (str != null) {
                        int number = 0;
                        for (int i = 0; i < str.length(); i++) {
                            char ch = str.charAt(i);
                            if (ch!=' ') {
                                number++;
                            } else if (number > 0) {
                                String substring = str.substring(i - number, i);
                                if (!words.containsKey(substring)) {
                                    words.put(substring, new LinkedList<>());
                                }
                                words.get(substring).addAll(Arrays.asList(pos[0], pos[1]));
                                number = 0;
                                pos[1]++;
                            }
                        }
                        if (number > 0) {
                            String substring = str.substring(str.length() - number).toLowerCase();
                            if (!words.containsKey(substring)) {
                                words.put(substring, new LinkedList<>());
                            }
                            words.get(substring).addAll(Arrays.asList(pos[0], pos[1]));
                            pos[1]++;
                        }
                    }
                    if (scan.hasNotNextInWord()) {
                        pos[1] = 1;
                        pos[0]++;
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                scan.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1], false), StandardCharsets.UTF_8));
        words.forEach((key, value) -> {
            try {
                out.write(key + " " + value.size() / 2);
                for (int i = 0; i < value.size(); i += 2) {
                    out.write(" " + value.get(i) + ":" + value.get(i + 1));
                }
                out.newLine();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        });
        out.close();
    }
}