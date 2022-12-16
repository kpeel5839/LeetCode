import java.util.*;

class MyQueue {
    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<>();    
        
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
            
        stack.push(x);
        
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {    
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */