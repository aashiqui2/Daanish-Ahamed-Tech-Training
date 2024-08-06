class DoubleLinkedList {
    Node head;

    class Node {
        Node prev;
        int data;
        Node next;

        Node(int val) {
            data = val;
            prev = null;
            next = null;
        }
    }

    DoubleLinkedList() {
        head = null;
    }

    public void insertBegin(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
    }

    public void insertAtEnd(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.prev = temp;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void delteAtBegin() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void delteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }
    }

    public void insertAtpos(int pos, int val) {
        Node newnode = new Node(val);
        if (pos == 0) {
            insertBegin(val);
            return;
        }
        if (head == null) {
            System.out.println("list is empty unable to insert at position");
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Unbale to insert");
            return;
        }
        if (temp.next == null) {
            temp.next = newnode;
            newnode.prev = temp;
        } else {
            newnode.prev = temp;
            newnode.next = temp.next;
            temp.next.prev = newnode;
            temp.next = newnode;
        }

    }

    public void delteAtpos(int pos) {
        if (head == null) {
            System.out.println("list is empty unable to insert at position");
            return;
        }
        if(pos==0)
        {
            delteAtBegin();
            return;
        }
        Node temp=head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

    }
}

public class Demo {
    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList();
        dl.insertBegin(3);
        dl.insertBegin(2);
        dl.insertBegin(1);
        dl.insertAtEnd(4);
        // dl.delteAtBegin();
        // dl.delteAtEnd();
        // dl.delteAtEnd();
        // dl.insertAtpos(5, 0);
        dl.delteAtpos(2);
        dl.display();

    }
}
