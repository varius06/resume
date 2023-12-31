package exception;

public class EmptyLoginException extends Exception {
    private String msg;

    public EmptyLoginException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
