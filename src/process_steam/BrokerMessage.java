package process_steam;

public class BrokerMessage {

    private final String data;

    public String getData() {
        return data;
    }

    public BrokerMessage(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.getClass() + "[data = " + this.data +"]";
    }
}
