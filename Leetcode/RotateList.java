//https://leetcode.com/problems/rotate-list/
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int length = 0;
        ListNode tmp = head, tail = null;
        while (tmp != null) {
            length++;
            tail = tmp;
            tmp = tmp.next;
        }
        int breakPoint = length - k % length;
        length = 0;
        tmp = head;
        while (tmp != null) {
            if (++length == breakPoint) {
                tail.next = head;
                head = tmp.next;
                tmp.next = null;
                return head;
            }
            tmp = tmp.next;
        }
        return head;
    }
}
