package process_steam;

import java.util.concurrent.TimeUnit;

public final class MessageProducingTask implements Runnable {

    private static final String MESSAGE_OF_MESSAGE_IS_PRODUCED = "message '%s' is produced.\n";
    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING = 3;

    private final CommunicationBroker communicationBroker;

    private final MessageFactory messageFactory;

    public MessageProducingTask(CommunicationBroker communicationBroker) {
        this.communicationBroker = communicationBroker;
        this.messageFactory = new MessageFactory();
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                final BrokerMessage messageBroker = this.messageFactory.create();
                TimeUnit.SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING);
                this.communicationBroker.produce(messageBroker);
                System.out.printf(MESSAGE_OF_MESSAGE_IS_PRODUCED, messageBroker);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }

    private static final class MessageFactory {
        private static final int INITIAL_NEXT_MESSAGE_INDEX = 1;

        private static final String TEMPLATE_CREATED_MESSAGE_DATA = "Message#%d";

        private int nextMassageIndex;

        public MessageFactory() {
            this.nextMassageIndex = INITIAL_NEXT_MESSAGE_INDEX;
        }

        public BrokerMessage create() {
            return new BrokerMessage(String.format(TEMPLATE_CREATED_MESSAGE_DATA, this.nextMassageIndex++));
        }

    }
}
