class MyStack {
    Queue<Integer> queue1=new LinkedList<Integer>();
    Queue<Integer> queue2=new LinkedList<Integer>();
    int i = 1;
    // Push element x onto stack.
    public void push(int x) {
        if (i == 1)
        {
            queue1.add(x);
            for(int j = 0;  queue2.size() > 0; j++)
                {queue1.add(queue2.poll());}
            i = 2;
        }
        else
        {
            queue2.add(x);
            for(int j = 0; queue1.size() > 0; j++)
                {queue2.add(queue1.poll());}
            i = 1;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (i == 2)
            queue1.poll();
        else
            queue2.poll();
    }

    // Get the top element.
    public int top() {
        if (i == 2)
            return queue1.peek();
        else
            return queue2.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty())
            return true;
        return false;
    }
}