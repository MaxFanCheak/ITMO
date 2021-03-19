import java.io.BufferedWriter;
import java.io.IOException;

abstract class AbstractLogger implements Logger {
    protected int minPriority = 0;
    protected BufferedWriter log;

    public void setMinPriority(Priorities newMinPriority) {
        if (newMinPriority != null) {
            minPriority = newMinPriority.ordinal();
        }
    }

    @Override
    public void log(String message) {
        if (getStringPriority(message).ordinal() >= minPriority) {
            try {
                log.write(message + "\n");
            } catch (IOException e) {
                System.out.println("Error while logging " + e.getMessage());
            }
        }
    }

    @Override
    public void log(String message, Throwable cause) {
        if (getStringPriority(message).ordinal() >= minPriority) {
            try {
                log.write(message + " Caused by " + cause.getMessage() + "\n");
            } catch (IOException e) {
                System.out.println("Error while logging " + e.getMessage());
            }
        }
    }

    private Priorities getStringPriority(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        if (str.charAt(i++) == '[') {
            while (i != str.length() && str.charAt(i) != ']') {
                sb.append(str.charAt(i++));
            }
            for (Priorities pr : Priorities.values()) {
                if (sb.toString().equals(pr.name())) {
                    return pr;
                }
            }
        }
        return Priorities.values()[0];
    }

    public void close() {
        try {
            if (log != null)
                log.close();
        } catch (Exception e) {
            System.out.println("Error in logger closing: " + e.getMessage());
        }
    }
}
