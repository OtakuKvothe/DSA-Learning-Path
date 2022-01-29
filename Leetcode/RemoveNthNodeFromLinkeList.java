//https://leetcode.com/problems/remove-nth-node-from-end-of-list
public class RemoveNthNodeFromLinkeList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode node = head;
        int l = 0;
        while(node!=null){
            l++;
            node=node.next;
        }
        
        int x=0;
        ListNode prev=null;
        node = head;
        while(node != null){
            x++;
            if(l+1-x==n){
                if(prev != null){
                    prev.next = node.next;
                    node = null;
                    break;
                }else{
                    node=node.next;
                    head=node;
                }
            }else{
                prev=node;
                node=node.next;
            }
        }
        
        return head;
    }
}
