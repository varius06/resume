package oop_callback;

public class TestCallback {
    public static void main(String[] args) {
        final Log log = new Log.Local();
        Executor executor = new Executor();
        //DataCallback<DataContainer, ErrorInfo> dataCallback = new DataCallback.Base(log);
       /* DataCallback dataCallback = new DataCallback() {
            @Override
            public void returnSuccess(DataContainer dataContainer) {
                dataContainer.show();
            }

            @Override
            public void returnError(ErrorInfo errorInfo) {
                errorInfo.log(log);
            }
        };*/
        DataCallback<DataContainer, ErrorInfo> dataCallback = new DataCallback<DataContainer, ErrorInfo>() {
            @Override
            public void returnSuccess(DataContainer dataContainer) {
                dataContainer.show();
            }
        };
        executor.execute(dataCallback);
    }
}
