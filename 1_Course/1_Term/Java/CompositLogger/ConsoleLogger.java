import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(Priorities minPriority) {
        setMinPriority(minPriority);
        log = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
