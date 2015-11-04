class MyStack {
    Queue<Integer> queue1=new LinkedList<Integer>();
    Queue<Integer> queue2=new LinkedList<Integer>();
    boolean sign=true;
    // Push element x onto stack.
    public void push(int x) {
        if(sign){
            queue1.add(x);
            while(queue2.size()>0){
                queue1.add(queue2.poll());
            }
            sign=false;
        }else{
            queue2.add(x);
            while(queue1.size()>0){
                queue2.add(queue1.poll());
            }
            sign=true;
        }
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(sign){
            queue2.poll();
        }else{
            queue1.poll();
        }
    }

    // Get the top element.
    public int top() {
        if(sign){
            return queue2.peek();
        }else{
            return queue1.peek();
        }
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue1.isEmpty()&&queue2.isEmpty()){
            return true;
        }
        return false;
        
    }
}