class LFUCache {
    public Node root;
    public int capacity;
    public int count;
    public int[] keyToCount;
    public int[] keyToValue;
    public Node[] keyToNode;
    public Map<Integer, Node> countToNode;
    
    public LFUCache(int capacity) {
        root = new Node(-1); // 의미 없느 노드
        this.capacity = capacity;
        count = 0;
        keyToNode = new Node[100001];
        keyToValue = new int[100001];
        keyToCount = new int[100001];
        countToNode = new HashMap<>();
        
        for (int i = 0; i <= 100000; i++) {
            countToNode.put(i, null);
            keyToValue[i] = -1;
        }
    }
    
    public int get(int key) {            
        // System.out.println("get : " + key);
        if (keyToValue[key] != -1) {
            Node insertNode = new Node(key);
            Node currentNode = countToNode.get(keyToCount[key]);        
        
            if (currentNode.key == key) { // 얘가 가장 앞에 있는 경우            
                if (currentNode.pre.key != -1 && keyToCount[currentNode.pre.key] == keyToCount[key]) {
                    countToNode.put(keyToCount[key], currentNode.pre);            
                } else {                                
                    countToNode.put(keyToCount[key], null);
                }
            }

            keyToCount[key]++;

            if (currentNode.next == null) {
                insert(currentNode, insertNode);
            } else {
                int nextCount = keyToCount[currentNode.next.key];

                if (nextCount != keyToCount[key]) {            
                    insert(currentNode, insertNode);    
                } else {            
                    insert(countToNode.get(nextCount), insertNode);
                }
            }

            countToNode.put(keyToCount[key], insertNode);
            remove(keyToNode[key]); // 지워줌
            keyToNode[key] = insertNode;     
            
//             System.out.print("순회 : ");
//             Node cur = root;

//             while (true) {
//                 cur = cur.next;
//                 if (cur == null) {
//                     break;
//                 }
//                 System.out.print(cur.key + " ");
//             }

//             System.out.println();
        }
    
        return keyToValue[key];
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        // System.out.println("add : " + key);
        if (keyToValue[key] != -1) {
            // 이때는 그냥 get 처럼 하면 됨
            Node insertNode = new Node(key);
            Node currentNode = countToNode.get(keyToCount[key]);
        
            if (currentNode.key == key) { // 얘가 가장 앞에 있는 경우            
                if (currentNode.pre.key != -1 && keyToCount[currentNode.pre.key] == keyToCount[key]) {
                    countToNode.put(keyToCount[key], currentNode.pre);            
                } else {                                
                    countToNode.put(keyToCount[key], null);
                }
            }

            keyToCount[key]++;

            if (currentNode.next == null) {
                insert(currentNode, insertNode);
            } else {
                int nextCount = keyToCount[currentNode.next.key];

                if (nextCount != keyToCount[key]) {            
                    insert(currentNode, insertNode);    
                } else {            
                    insert(countToNode.get(nextCount), insertNode);
                }
            }

            countToNode.put(keyToCount[key], insertNode);
            remove(keyToNode[key]); // 지워줌
            keyToNode[key] = insertNode;
            keyToValue[key] = value;
        } else {
            if (count >= capacity) { // 삭제 해줘야함, root 앞에        
                Node checkNode = root.next;        
                Node countNode = countToNode.get(keyToCount[checkNode.key]);            

                if (countNode.key == checkNode.key) { // key 가 같으면 둘이 같은 노드임
                    countToNode.put(keyToCount[checkNode.key], null);
                }

                count--;
                remove(checkNode);
                keyToValue[checkNode.key] = -1;
                keyToCount[checkNode.key] = 0;
                keyToNode[checkNode.key] = null;
            }        

            count++;
            keyToValue[key] = value;
            keyToCount[key] = 1;            

            Node node = countToNode.get(1);
            Node insertNode = new Node(key);
            keyToNode[key] = insertNode;        

            if (node == null) {    
                insert(root, insertNode);        
            } else {                
                insert(node, insertNode);           
            }

            countToNode.put(keyToCount[key], insertNode); // put 해주고           
        }    
            
//         System.out.print("순회 : ");
//         Node cur = root;
        
//         while (true) {
//             cur = cur.next;
//             if (cur == null) {
//                 break;
//             }
//             System.out.print(cur.key + " ");
//         }
        
//         System.out.println();
    }
    
    public class Node {
        Node pre;
        Node next;
        int key;
        
        Node(int key) {
            this.key = key;
            pre = null;
            next = null;
        }
        
        @Override
        public String toString() {
            return key + "";
        }
    }
    
    public void remove(Node current) { // current 삭제    
        if (current.pre != null && current.next != null) {        
            current.pre.next = current.next;
            current.next.pre = current.pre;        
            return;    
        }
        
        current.pre.next = null;
    }
    
    public void insert(Node current, Node insertNode) {
        if (current.next == null) {        
            current.next = insertNode;
            insertNode.pre = current;
        } else {
            insertNode.next = current.next;
            insertNode.pre = current;
            current.next.pre = insertNode;
            current.next = insertNode;   
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */