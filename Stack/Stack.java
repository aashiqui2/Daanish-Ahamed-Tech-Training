public class Stack {
    int[] stack;
    int size;
    int top;

    Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is overflow");
            return;
        }
        stack[++top] = data;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is underflow");
            return -1;
        }
        return stack[top--];
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("stack is underflow");
            return;
        }
        System.out.println("Topest element " + stack[top]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("stack is underflow");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public void update(int pos, int data) {
        if (isEmpty()) {
            System.out.println("stack is underflow");
            return;
        }
        if(pos<0 ||pos>top)
        {
            System.out.println("position out of bounds");
            return;
        }
        stack[pos]=data;
    }

    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        s.peek();
        int poppedElement = s.pop();
        System.err.println("Popped element " + poppedElement);
        s.update(3, 1);
        s.display();
    }

}