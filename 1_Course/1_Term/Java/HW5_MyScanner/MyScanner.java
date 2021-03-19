import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyScanner {
    private final BufferedReader scanner;
    private int statusOfReading = 0;
    public MyScanner(InputStream in) {
        scanner = new BufferedReader(new InputStreamReader(in));
    }
    public MyScanner(File in) throws FileNotFoundException {
        scanner = new BufferedReader(new InputStreamReader(
                new FileInputStream(in), StandardCharsets.UTF_8));
    }
    public Integer nextInt() throws IOException {
        StringBuilder sb = new StringBuilder();
        int i = scanner.read();
        char c = (char) i;
        boolean intw = true;
        while (intw && i != -1 && c != '\n') {
            while (Character.isWhitespace(c)) {
                c = (char) scanner.read();
            }
            intw = false;
            while (!Character.isWhitespace(c) && i != -1 && c != '\n') {
                sb.append(c);
                if (!Character.isDigit(c) && c != '-' && c != '+') {
                    intw = true;
                    break;
                }
                i = scanner.read();
                c = (char) i;
                if ((c == '-' || c == '+')) {
                    break;
                }
            }
        }
        if (i == -1) {
            statusOfReading = -1;
        } else if (i == '\n') {
            statusOfReading = 1;
        } else {
            statusOfReading = 0;
        }
        if (sb.length() == 0) {
            return null;
        }
        return Integer.parseInt(sb.toString());
    }
    public String nextLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int i = scanner.read();
        char c = (char) i;
        while (Character.isWhitespace(c) && i != -1 && c != '\n') {
            i = scanner.read();
            c = (char) i;
        }
        while (Character.isLetter(c) || (Character.getType(c) == Character.DASH_PUNCTUATION) || (c == '\'')) {
            sb.append(c);
            i = scanner.read();
            c = (char) i;
        }
        if (i == -1) {
            statusOfReading = -1;
        } else if (i == '\n') {
            statusOfReading = 1;
        } else {
            statusOfReading = 0;
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }


    public boolean hasNotNextword() {
        if(statusOfReading == -1) return true;
        return false;
    }

    public boolean hasNotNextInWord() {
        if(statusOfReading == 1) return true;
        return false;
    }
    public void close() throws IOException {
        scanner.close();
    }
}