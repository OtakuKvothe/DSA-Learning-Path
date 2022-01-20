//https://leetcode.com/problems/add-two-numbers/
public class Add2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
            System.out.println(s);
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
