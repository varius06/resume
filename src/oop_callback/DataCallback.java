package oop_callback;

public interface DataCallback<T, E> {

    void returnSuccess(DataContainer dataContainer);


    class Base implements DataCallback<DataContainer, ErrorInfo>{

        private final Log log;

        public Base(Log log) {
            this.log = log;
        }

        @Override
        public void returnSuccess(DataContainer dataContainer) {
            dataContainer.show();
        }

    }

}
