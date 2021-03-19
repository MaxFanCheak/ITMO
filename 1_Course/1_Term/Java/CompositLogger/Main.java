public class Main {
    public static void main(String[] args) {
        AbstractLogger[] list = {new ConsoleLogger(Priorities.Info), new FileLogger("Output.txt", Priorities.Debug)};
        CompositeLogger info = new CompositeLogger(list);
        info.log("[Info]" + "message yes");
        info.log("[Info]" + "error message", new IllegalArgumentException("oh no"));
        info.log("[Debug]" + "message yes");
        info.log("[Debug]" + "error message", new IllegalArgumentException("oh no"));
        info.log("[Error]" + "message yes");
        info.log("[Error]" + "error message", new IllegalArgumentException("oh no"));
        info.close();
    }
}
