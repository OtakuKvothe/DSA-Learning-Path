//https://leetcode.com/problems/flatten-nested-list-iterator

import java.util.Iterator;
import java.util.Queue;

public class FlattenNestedListIterator implements Iterator<Integer> {
    
    private Queue<Integer> q;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        for(NestedInteger n: nestedList) {
            addNums(q, n);
        }
    }
    
    private void addNums(Queue<Integer> q, NestedInteger nInt) {
        if(nInt.isInteger()) {
            q.add(nInt.getInteger());
        } else {
            for(NestedInteger nums: nInt.getList()) {
                addNums(q, nums);
            }
        }
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
}
