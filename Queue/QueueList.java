public class QueueList {
    private Node front, rear;
    class Node{
        int data;
        Node next;
        Node(int val){
            data=val;
            next=null;
        }
    }

    public QueueList() {
        this.front = this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);

        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }

        this.rear.next = newNode;
        this.rear = newNode;
    }

    public int dequeue() {
        if (this.front == null) {
            throw new RuntimeException("Dequeue from empty queue");
        }

        Node temp = this.front;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }

        return temp.data;
    }

    public int peek() {
        if (this.front == null) {
            throw new RuntimeException("Peek from empty queue");
        }
        return this.front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueList q = new QueueList();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.print("Queue: ");
        q.display(); 

        System.out.println("Dequeued item: " + q.dequeue()); 
        System.out.print("Queue after dequeue: ");
        q.display();

        System.out.println("Front item: " + q.peek());  
    }
}
