package MessagingQueue.exceptions;

public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("Queue is empty!");
    }
}
