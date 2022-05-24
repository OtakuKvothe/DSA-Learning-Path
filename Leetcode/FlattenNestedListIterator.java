//https://leetcode.com/problems/flatten-nested-list-iterator

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenNestedListIterator implements Iterator<Integer> {

    private Queue<Integer> q;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        for(NestedInteger n: nestedList) {
            addNums(q, n);
        }
    }

    private void addNums(Queue<Integer> q, NestedInteger nInt) {
        if (nInt.isInteger()) {
            q.add(nInt.getInteger());
        } else {
            for (NestedInteger nums : nInt.getList()) {
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

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}