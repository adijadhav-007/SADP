public class LoggerService {

    private static LoggerService instance;
    private LoggerService() {
        System.out.println("LoggerService instance created.");
    }
    public static LoggerService getInstance() {
        if (instance == null) {
            synchronized (LoggerService.class) {
                if (instance == null) {
                    instance = new LoggerService();
                }
            }
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
    public static void main(String[] args) {
        LoggerService logger1 = LoggerService.getInstance();
        logger1.log("Starting application...");

        LoggerService logger2 = LoggerService.getInstance();
        logger2.log("Application is running.");
        System.out.println("Same instance? " + (logger1 == logger2)); // true
    }
}

