package oop_callback;

public interface DataCallback {

    void returnSuccess(DataContainer dataContainer);

    void returnError(ErrorInfo errorInfo);

}
