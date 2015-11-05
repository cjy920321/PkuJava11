class MinStack {
        Stack<Integer> Stack1 = new Stack<Integer>(); //正常数据压栈
        Stack<Integer> minStack = new Stack<Integer>();//最小者

        public void push(int x) {
            Stack1.push(x);  //x压栈
            if (minStack.empty()) {//如果最小数栈为空
                minStack.push(x);
            } else if (minStack.peek() >= x) { //当前数比栈顶数字小
                minStack.push(x);
            }
        }

        public void pop() {
            int poppedElement = Stack1.pop();
            if (poppedElement == minStack.peek()) { //如果出栈的数是最小的数字
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