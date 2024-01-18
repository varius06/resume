package process_steam;

import java.util.ArrayDeque;
import java.util.Deque;

public final class CommunicationBroker {

    private final Deque<BrokerMessage> messageToBeConsumed;

    private final int maxStorageMessage;

    public CommunicationBroker(int maxStorageMessage) {
        this.messageToBeConsumed = new ArrayDeque<>(maxStorageMessage);
        this.maxStorageMessage = maxStorageMessage;
    }

    public synchronized void produce(final BrokerMessage messageBroker) {
        /*while (this.messageToBeConsumed.size() >= maxStorageMessage) {

        }
        this.messageToBeConsumed.add(messageBroker);*/

        try {
            while (this.messageToBeConsumed.size() >= maxStorageMessage) {
                super.wait();
            }
            this.messageToBeConsumed.add(messageBroker);
            super.notify();
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized BrokerMessage consume() {
        /*while (this.messageToBeConsumed.isEmpty()) {

        }
        return this.messageToBeConsumed.poll();*/

        try {
            while (this.messageToBeConsumed.isEmpty()) {
                super.wait();
            }
            final BrokerMessage brokerMessage = this.messageToBeConsumed.poll();
            notify();
            return brokerMessage;
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new  RuntimeException(e);
        }
    }
}
