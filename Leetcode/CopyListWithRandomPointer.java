
//https://leetcode.com/problems/copy-list-with-random-pointer
import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Node fakeHead = new Node(0), node = head, p2 = fakeHead;
        while (node != null) {
            Node tmp = new Node(node.val);
            p2.next = tmp;
            p2 = p2.next;
            map.put(node, tmp);
            node = node.next;
        }
        map.put(null, null);
        node = head;
        p2 = fakeHead.next;
        while (node != null && p2 != null) {
            p2.random = map.get(node.random);
            p2 = p2.next;
            node = node.next;
        }
        return fakeHead.next;
    }
}
