public class StackArray {
    int[] stack;
    int size;
    int top;

    StackArray(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Nothing to display");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
    }
    public int peek()
    {
        if (isEmpty()) {
            System.out.println("stack is underflow");
            return -1;
        }
        return stack[top];
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is underflow");
            return -1;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public static void main(String[] args) {
        StackArray s = new StackArray(5);
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        int popedElement = s.pop();
        System.out.println("popedElement " + popedElement);
        int ToppestElement = s.pop();
        System.out.println("ToppestElement " + ToppestElement);
        s.display();
    }

}
