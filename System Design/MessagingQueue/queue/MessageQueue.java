package MessagingQueue.queue;

import MessagingQueue.exceptions.EmptyQueueException;
import MessagingQueue.node.Node;

public class MessageQueue {
    Node head, tail;

    public MessageQueue() {
        head = null;
        tail = null;
    }

    void addMessage(String message) {
        Node node = new Node(message);

        if(this.tail == null) {
            this.head = this.tail = node;
            return;
        }

        this.tail.setNext(node);
        this.tail = tail.getNext();
    }

    String pollMessage() throws EmptyQueueException {
        if(this.head == null) {
            tail = null;
            throw new EmptyQueueException();
        }

        Node node = head;
        head = head.getNext();

        if(head == null)
            tail = null;
        
        return node.getMessage();
    }

    String peekMessage() throws EmptyQueueException {
        if(this.head == null) {
            this.tail = null;
            throw new EmptyQueueException();
        }

        return this.head.getMessage();
    }

    boolean isEmpty() {
        return head != null;
    }
}
