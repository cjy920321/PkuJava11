class MinStack {
    SingleList head=null;
    SingleList min=null;
    SingleList p=null;
    public void push(int x) {
        if(head==null){
            head=new SingleList(x);
            min=new SingleList(x);
        }else{
            p=head;
            head=new SingleList(x);
            head.next=p;
            if(x<min.val){
                p=min;
                min=new SingleList(x);
                min.next=p;
            }else{
                p=min;
                min=new SingleList(p.val);
                min.next=p;
            }
        }
    }

    public void pop() {
        head=head.next;
        min=min.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min.val;
    }
}

class SingleList{
    int val;
    SingleList next;
    SingleList(int x){
        val=x;
        next=null;
    }
}