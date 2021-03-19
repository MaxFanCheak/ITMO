import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
public class WordStatInputPrefix {
        static MyScanner scan;
        public static void main(String args[]){
            Map<String, Integer> words = new LinkedHashMap<>();
            try{
                Charset utf8 = StandardCharsets.UTF_8;
                scan = new MyScanner(new File(args[0]));
                try {
                String str;
                String substring = "";
                while (!scan.hasNotNextword()) {
                    str = scan.nextLine();
                        if(str!=null){
                        if(str.length()>=3) {
                            substring = str.substring(0, 3).toLowerCase();
                            if (words.get(substring) == null) {
                                words.put(substring, 1);
                                System.out.println(words.get(substring));
                            }else {
                                words.put(substring, words.get(substring) + 1);
                            }
                        }
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
                    scan.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Not found file");
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }
