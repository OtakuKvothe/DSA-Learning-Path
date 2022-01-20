//https://leetcode.com/problems/linked-list-cycle-ii
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                ListNode s2 = head;
                 while(slow != s2){
                     slow = slow.next;
                     s2 = s2.next;
                 }
                 return s2;
            } 
        }
        return null;
    }
}
