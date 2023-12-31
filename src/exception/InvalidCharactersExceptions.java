package exception;

public class InvalidCharactersExceptions extends Exception{
    private String msg;

    InvalidCharactersExceptions(String msg) {
        super(msg);
        this.msg = msg;
    }
}
