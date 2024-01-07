package oop_callback;

public class Executor {

    public void execute(DataCallback dataCallback) {
        try {
            //dataCallback.returnSuccess(new DataContainer());
            throw new IllegalStateException("IllegalStateException");
        } catch (Exception e) {
            dataCallback.returnError(new ErrorInfo(e.getMessage(), ""));
        }
    }
}
