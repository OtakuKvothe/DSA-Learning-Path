import java.util.Random;

public class RandomListNode {
    ListNode head=null;
    Random r=new Random();
    
    public RandomListNode(ListNode head) {
        this.head=head;
    }
    
    public int getRandom() {
        int res = head.val;
        ListNode node = head.next;
        int i=2;
        while(node!=null){
            double p=r.nextDouble();
            double q=1.0/i;
            if(p<q){
                res=node.val;
            }
            node=node.next;
            i++;
        }
        return res;
    }
}
