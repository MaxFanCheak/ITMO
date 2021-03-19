import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class WordStatInput {
    public static void main(String args[]) {
        try {
            Charset utf8 = StandardCharsets.UTF_8;
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0])), utf8));
            try {
                StringBuilder word;
                Map<String, Integer> words = new LinkedHashMap<String, Integer>();
                int end;
                word = new StringBuilder();
                while ((end = reader.read()) != -1) {
                    char sym = (char) end;
                    if (Character.isLetter(sym) || (Character.getType(sym) == Character.DASH_PUNCTUATION) || (sym == '\'')) {
                        if (Character.isUpperCase(end)) {
                            word.append(Character.toLowerCase((char) end));
                        } else {
                            word.append((char) end);
                        }
                    } else if ((word.length() != 0) && (word != null)) {
                        if (words.get(word.toString()) == null) {
                            words.put(word.toString(), 1);
                        } else {
                            words.put(word.toString(), words.get(word.toString()) + 1);
                        }
                        word.replace(0, word.length(), "");
                    }
                }
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1], false), utf8));
                try {
                    for (Map.Entry<String, Integer> pair : words.entrySet()) {
                        writer.write(pair.getKey() + " " + pair.getValue());
                        writer.newLine();
                    }
                } catch (IOException err) {
                    System.out.print("Error" + err.getMessage());
                } finally {
                    writer.close();
                }
            } catch (IOException er) {
                System.out.print("Error" + er.getMessage());
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Not found file");
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
