package exception;

public class LengthException extends Exception{
    private String msg;

    LengthException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
