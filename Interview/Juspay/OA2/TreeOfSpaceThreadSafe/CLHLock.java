package TreeOfSpaceThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

public class CLHLock {
    private final AtomicReference<Node> tail;

    private final ThreadLocal<Node> myNode;

    private final ThreadLocal<Node> myPred;

    public CLHLock() {

        tail = new AtomicReference<>(new Node());

        myNode = ThreadLocal.withInitial(() -> new Node());

        myPred = ThreadLocal.withInitial(() -> null);

    }

    public void lock() {

        Node node = myNode.get();

        node.locked = true;

        Node pred = tail.getAndSet(node);

        myPred.set(pred);

        while (pred.locked) {
        }

    }

    public void unlock() {

        Node node = myNode.get();

        node.locked = false;

        myNode.set(myPred.get());

    }

    static class Node {

        volatile boolean locked = false;

    }
}
