public class ReverseLinkedList {
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

    public void reverse() {
        Node prev=null;
        Node temp=head;
        Node next=null;
        while (temp!=null) {
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        head=prev;
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
        ReverseLinkedList rl = new ReverseLinkedList();
        rl.Insert(30);
        rl.Insert(40);
        rl.Insert(50);
        rl.Insert(60);
        rl.reverse();
        rl.display();
    }
}
