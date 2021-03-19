import java.io.IOException;

interface Logger {
    abstract void log(String message) throws IOException;
    abstract void log(String message, Throwable cause) throws IOException;
}
