class MinStack {
        Stack<Integer> Stack1 = new Stack<Integer>(); //��������ѹջ
        Stack<Integer> minStack = new Stack<Integer>();//��С��

        public void push(int x) {
            Stack1.push(x);  //xѹջ
            if (minStack.empty()) {//�����С��ջΪ��
                minStack.push(x);
            } else if (minStack.peek() >= x) { //��ǰ����ջ������С
                minStack.push(x);
            }
        }

        public void pop() {
            int poppedElement = Stack1.pop();
            if (poppedElement == minStack.peek()) { //�����ջ��������С������
                minStack.pop();
            }
        }

        public int top() {
            return Stack1.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }