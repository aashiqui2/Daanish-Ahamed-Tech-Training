public class QueueArray {
    int[] queue;
    int size;
    int front,rear;
    QueueArray(int size)
    {
        this.size=size;
        queue=new int[size];
        front=rear=0;
    }
    public void enqueue(int val)
    {
        if(isFull())
        {
            System.out.println("Queue is Full");
            return;
        }
        queue[rear++]=val;
    }
    public boolean isFull()
    {
        return rear==size;
    }
    public boolean isEmpty()
    {
        return rear==front;
    }
    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty nothing to remove");
            return -1;
        }
           int removedElement=queue[front++];
           return removedElement;
    }
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return;
        }
        for(int i=front;i<rear;i++)
        {
            System.out.print(queue[i]+" ");
        }
    }
    public static void main(String[] args) {

        QueueArray q=new QueueArray(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        int removedElement=q.dequeue();
        System.out.println("removedElement is "+removedElement);
        removedElement=q.dequeue();
        System.out.println("removedElement is "+removedElement);
        q.display();


    }
}
