public class RotateSingleLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void Insert(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }
    public void rotate(int k)
    {
        if(k==0|| head==null)
        {
            return;
        }
        Node temp=head;
        int length=1;
        while(temp.next!=null)
        {
            temp=temp.next;
            length++;
        }
        k=k%length;
        if(k==0)
        {
            return;
        }
        temp.next=head;
        temp=head;
        for(int i=1;i<length-k;i++)
        {
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RotateSingleLinkedList rl = new RotateSingleLinkedList();
        rl.Insert(30);
        rl.Insert(40);
        rl.Insert(50);
        rl.Insert(60);
        rl.rotate(1);
        rl.display();
    }
}
