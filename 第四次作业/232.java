class MyQueue {
    Stack<Integer> stackpush=new Stack<Integer>();
    Stack<Integer> stackpop=new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stackpush.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stackpop.isEmpty()){
            int n=stackpush.size();
            for(int i=0;i<n;i++){
                stackpop.push(stackpush.pop());
            }
            stackpop.pop();
        }
        else{
            stackpop.pop();
        }
        
    }

    // Get the front element.
    public int peek() {
        if(stackpop.isEmpty()){
            int n=stackpush.size();
            for(int i=0;i<n;i++){
                stackpop.push(stackpush.pop());
            }
            return stackpop.peek();
        }
        else{
            return stackpop.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(stackpush.isEmpty()&&stackpop.isEmpty()){
            return true;
        }
        return false;
    }
}