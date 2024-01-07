package oop_callback;

public class ErrorInfo {
    private final String message;
    public final String cause;

    public ErrorInfo(String message, String cause) {
        this.message = message;
        this.cause = cause;
    }

    public void log(Log logger) {
        logger.log("massage " + message + " cause " + cause);
    }
}
