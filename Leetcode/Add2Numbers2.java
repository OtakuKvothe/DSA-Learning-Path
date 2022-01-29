//https://leetcode.com/problems/add-two-numbers-ii
public class Add2Numbers2 {
    //There are honestly too many ways to solve this problem, all of similar O(n) complexity
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverse(add(reverse(l1), reverse(l2)));
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }        
        return prev;
    }
    
    public ListNode add(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode l=null, prev=null;
        while(l1!=null||l2!=null){
            int s=carry;
            if(l1!=null) {
                s+=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                s+=l2.val;
                l2=l2.next;
            }            
            carry=s/10;
            if(prev==null) {
                prev=new ListNode(s%10);
                l=prev;
            }
            else{
                prev.next=new ListNode(s%10);
                prev=prev.next;
            }  
        }
        if(carry > 0){
            prev.next=new ListNode(1);
        }
        return l;
    }
}
