class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MinStack() {
        stack1= new Stack<>();
        stack2= new Stack<>();
    }
    
    public void push(int value) {
        stack1.push(value);
        if(stack2.isEmpty()){
            stack2.push(value);
        }else{
            if(value<=stack2.peek()){
                stack2.push(value);
                return;
            }
        }
    }
    
    public void pop() {
        if(stack1.isEmpty() || stack2.isEmpty()){
            return;
        }
        if(stack1.peek().equals(stack2.peek())){
            stack1.pop();
            stack2.pop();
            return;
        }else{
            stack1.pop();
            return;
        }
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */