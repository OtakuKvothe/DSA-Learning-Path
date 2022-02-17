//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = head, prev = null, nHead = head.next;
        while(node != null && node.next != null){
            ListNode n1 = node, n2 = node.next;
            n1.next = n2.next;
            n2.next = n1;
            if(prev != null) prev.next = n2;
            prev = n1;
            if(node != null && node.next != null) node = n1.next;
        }
        return nHead;
    }
}
