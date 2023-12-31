package exception;

public class PasswordConfirmationException extends Exception {
    private String msg;
    PasswordConfirmationException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
