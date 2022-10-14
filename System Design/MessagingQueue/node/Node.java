package MessagingQueue.node;

public class Node {
    String message;
    public String getMessage() {
        return message;
    }

    Node next;    

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(String message) {
        this.message = message;
    }

    public Node(String message, Node next) {
        this.message = message;
        this.next = next;
    }
}
