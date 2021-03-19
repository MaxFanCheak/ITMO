import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends AbstractLogger {
    public FileLogger(String filePath, Priorities minPriority) {
        setMinPriority(minPriority);
        try {
            File file = new File(filePath);
            file.createNewFile();
            log = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            System.out.print("Error while opening \"" + filePath + "\": " + e.getMessage());
        }
    }
}
