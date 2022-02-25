//https://leetcode.com/problems/merge-nodes-in-between-zeros
public class MergeNodesBetweenZeroes {
    public ListNode mergeNodes(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode h = head, node = head.next, prev = null;
        int tmp = 0;
        while(node != null){
            if(node.val == 0){
                h.next = new ListNode(tmp, node.next);
                if(prev == null) prev = h.next;
                h = h.next;
                tmp = 0;
            }else{
                tmp+=node.val;
            }
            node = node.next;
        }
        return prev;
    }
}
