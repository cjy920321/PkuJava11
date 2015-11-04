class MinStack {
    Node head = null;
    Node min = null;
    public void push(int x) {
        Node node = new Node(x);
        node.next = head;
        head = node;
        if (min != null && x > min.val)
            x = min.val;
        Node mnode = new Node(x);
        mnode.next = min;
        min = mnode;
    }

    public void pop() {
        if (head != null)
            head = head.next;
        if (min != null)
            min = min.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min.val;
    }
}

class Node {
    int val;
    Node next;
    Node (int x)
    {
        val = x; 
    }
}