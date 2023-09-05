/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copyHead = new Node(-1);
        Node cur = head;
        Node copyCur = copyHead;
        
        Map<Node, Node> m = new HashMap<>();
        
        while (cur != null) {
            Node newNode = new Node(cur.val);
            m.put(cur, newNode);
            copyCur.next = newNode; 
            newNode.random = cur.random;
            cur = cur.next;
            copyCur = copyCur.next;
        }
        
        cur = copyHead.next;
        
        while (cur != null) {
            cur.random = m.get(cur.random);
            cur = cur.next;
        }
        
        return copyHead.next;
    }
}