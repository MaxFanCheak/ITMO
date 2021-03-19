package Md2Html;

import java.io.*;
import java.nio.charset.*;

public class Md2Html {
    private static String inputString;
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static Charset utf_8;
    private static StringBuilder convertStrings;
    private static StringBuilder primordial;
    public static void main(String[] args) {
        convertStrings = new StringBuilder();
        primordial = new StringBuilder();
        utf_8=StandardCharsets.UTF_8;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), utf_8));
            while (inputString != null && (inputString = reader.readLine()) != null) {
                while (inputString != null && !inputString.isEmpty()) {
                    primordial.append(inputString).append('\n');
                    inputString = reader.readLine();
                }
                if (!primordial.toString().isEmpty()) {
                    primordial.setLength(primordial.length() - 1);
                   // new Str(par).toHtml(ans);
                    convertStrings.append('\n');
                    primordial.setLength(0);
                }
            }
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), utf_8));
                writer.write(convertStrings.toString());
            } catch (FileNotFoundException e) {
                System.out.println("File not found\n" + e.getMessage());
            } catch (IOException e) {
                System.out.println("Invalid output data\n" + e.getMessage());
            } finally {
                writer.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Invalid input data\n" + e.getMessage());
        } finally {
            try{
                reader.close();
            }
            catch (IOException e) {
                System.out.println("Error\n" + e.getMessage());
            }

        }
    }
    void toHtml(StringBuilder primordial) {
        int i = 0;
        while (i < primordial.length() && primordial.charAt(i) == '#') {
            i++;
        }
        if (i > 0 && primordial.charAt(i) == ' ') {
            new Caption(primordial).toHtml(convertStrings);
        } else {
            //new Paragraph(primordial).toHtml(convertStrings);
        }
    }
}
