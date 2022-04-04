//https://leetcode.com/problems/swapping-nodes-in-a-linked-list
public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = null, n2 = null;
        int t = k;
        
        for(var p = head; p != null; p = p.next) {
            n2 = n2 == null ? null : n2.next;
            if(--t == 0) {
                n1 = p;
                n2 = head;
            }
        }
        
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        
        return head;
    }
}
