import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class OddEvenLL {

    public static ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode tmp = head;
        int end = 1;
        while(tmp.next != null){
            tmp = tmp.next;
            end++;
        }
        int ind = 1;
        ListNode t = head, prev = null;
        while(ind <= end&&t != null){
            if(ind%2==0){
                tmp.next = new ListNode(t.val);
                prev.next = t.next;
                tmp = tmp.next;
            }
            prev = t;
            t=t.next;
            ind++;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("Started");
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            ListNode head = new ListNode();
            ListNode tmp = head;
            for(int i=0; i<n; i++){
                tmp.val=sc.nextInt();
                if(i<n-1){
                    tmp.next = new ListNode();
                    tmp=tmp.next;
                }
            }
            ListNode to = oddEvenList(head);
            while(to != null){
                System.out.print(to.val+" ");
                to=to.next;
            }
            System.out.println();
        }
    }
}
