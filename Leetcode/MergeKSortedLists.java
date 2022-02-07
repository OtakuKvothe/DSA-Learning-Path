import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(ListNode head: lists){
            if(head == null) continue;
            ListNode node = head;
            while(node != null){
                q.add(node.val);
                node = node.next;
            }
        }
        
        ListNode head = (q.isEmpty())?null:new ListNode(q.poll()), node = head;
        while(!q.isEmpty()){
            node.next = new ListNode(q.poll());
            node = node.next;
        }
        
        return head;
    }
}
