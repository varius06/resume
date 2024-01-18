package process_steam;

import java.util.concurrent.TimeUnit;

public final class MessageConsumingTask implements Runnable{

    private final CommunicationBroker communicationBroker;
    private static final int SECOND_DURATION_TO_SLEEP_BEFORE_CONSUMING = 1;

    private static final String TEMPLATE_MESSAGE_OF_MESSAGE_IS_CONSUMED = "message '%s' is consumed.\n";

    public MessageConsumingTask(CommunicationBroker communicationBroker) {
        this.communicationBroker = communicationBroker;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(SECOND_DURATION_TO_SLEEP_BEFORE_CONSUMING);
                final BrokerMessage messageBroker = communicationBroker.consume();
                System.out.printf(TEMPLATE_MESSAGE_OF_MESSAGE_IS_CONSUMED, messageBroker);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}
