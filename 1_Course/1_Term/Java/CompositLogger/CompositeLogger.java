import java.util.ArrayList;

public class CompositeLogger implements Logger {
    private ArrayList<AbstractLogger> loggerList = new ArrayList<>();

    public CompositeLogger(AbstractLogger[] list) {
        for (AbstractLogger logger : list) {
            addLogger(logger);
        }
    }

    public void addLogger(AbstractLogger newLogger) {
        if (newLogger != null) {
            loggerList.add(newLogger);
        }
    }

    @Override
    public void log(String message) {
        for (AbstractLogger logger : loggerList) {
            logger.log(message);
        }
    }

    @Override
    public void log(String message, Throwable cause) {
        for (AbstractLogger logger : loggerList) {
            logger.log(message, cause);
        }
    }

    public void close() {
        for (AbstractLogger logger : loggerList) {
            logger.close();
        }
    }
}
