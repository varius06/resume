package oop_callback;

public interface DataCallback {

    void returnSuccess(DataContainer dataContainer);

    void returnError(ErrorInfo errorInfo);

    class Base implements DataCallback{

        private final Log log;

        public Base(Log log) {
            this.log = log;
        }

        @Override
        public void returnSuccess(DataContainer dataContainer) {
            dataContainer.show();
        }

        @Override
        public void returnError(ErrorInfo errorInfo) {
            errorInfo.log(log);
        }
    }

}
