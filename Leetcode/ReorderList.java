import java.util.Stack;

//https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        Stack<ListNode> rHalf = new Stack<>();

        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = prev.next;
        slow = slow.next;
        while(slow != null){
            rHalf.add(slow);
            slow = slow.next;
            
        }
        prev.next = null;
        ListNode node = head;
        while(node != null){
            ListNode y = node.next;
            if(!rHalf.isEmpty()){
                ListNode t = rHalf.pop();
                t.next = node.next;
                node.next = t;
                node = t.next;
            }
            node = y;
        }
    }
}
