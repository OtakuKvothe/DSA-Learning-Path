package TreeOfSpaceThreadSafe.Mutex;

import java.util.concurrent.atomic.AtomicLong;

public class Mutex {

    private static AtomicLong threadLock = new AtomicLong();
    private long lock;
    
    public synchronized void acquire() {
        while(threadLock.get() > 0) {
            try {
                wait();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        threadLock.compareAndSet(0, Thread.currentThread().getId());
    }

    public synchronized void release() {
        while(threadLock.get() != Thread.currentThread().getId()) {
            try {
                wait();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        threadLock.compareAndSet(Thread.currentThread().getId(), 0);
        notifyAll();
    }

    public void lock() {
        while(lock != 0) {
            try {
                //Thread.currentThread().sleep(10);
                Thread.currentThread().wait();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        lock = Thread.currentThread().getId();
    }

    public void unlock() {
        lock = 0;
        try {
            Thread.currentThread().notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
