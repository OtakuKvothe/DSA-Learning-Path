package TreeOfSpaceThreadSafe;

import java.util.HashMap;

import TreeOfSpaceThreadSafe.Mutex.Mutex;

public class TreeQuery implements Runnable {

    CLHLock lock;
    TreeOfSpace tree;
    String query;
    HashMap<String, Boolean> result;

    public TreeQuery(TreeOfSpace tree, CLHLock lock, String query, HashMap<String, Boolean> result) {
        this.tree = tree;
        this.lock = lock;
        this.query = query;
        this.result = result;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        String[] parts = query.split(" ");
        boolean res = false;
        if(parts[0].equals("1")) {
            lock.lock();
            res = tree.lock(parts[1], parts[2]);
            result.put(query, res);
            lock.unlock();
        } else if(parts[0].equals("2")) {
            lock.lock();
            res = tree.unlock(parts[1], parts[2]);
            result.put(query, res);
            lock.unlock();
        } else {
            lock.lock();
            res = tree.upgrade(parts[1], parts[2]);
            result.put(query, res);
            lock.unlock();
        }
    }
}
