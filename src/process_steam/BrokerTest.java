package process_steam;

public class BrokerTest {
    public static void main(String[] args) {
        final int brokerMaxStoredMessages = 5;
        final CommunicationBroker communicationBroker = new CommunicationBroker(brokerMaxStoredMessages);
        final Thread producingThread = new Thread(new MessageProducingTask(communicationBroker));
        final Thread consumingThread = new Thread(new MessageConsumingTask(communicationBroker));
        producingThread.start();
        consumingThread.start();
    }
}
