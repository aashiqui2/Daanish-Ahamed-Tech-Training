class CircularLinkedList {
    CircularLinkedList() {
        head = null;
    }

    Node head;

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public void insertAtBegin(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
            newnode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newnode.next = head;
            head = newnode;
            temp.next = newnode;
        }
    }

    public void insertAtEnd(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
            newnode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }

    }

    public void insertAtpos(int pos, int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
            newnode.next = head;
        }
        if (pos == 0) {
            insertAtBegin(val);
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
                if (temp == head) {
                    System.out.println("Unable to insert");
                    return;
                }
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }
    }

    public void delteAtBegin() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
        }
    }

    public void delteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = head;
        }
    }

    public void delteAtpos(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (pos == 0) {
            delteAtBegin();
        } else {

            Node temp = head;
            Node prev = null;
            for (int i = 0; i < pos; i++) {
                prev = temp;
                temp = temp.next;
                if(temp==head){
                    System.out.println("outof range");
                    return;
                }
            }
            prev.next = temp.next;
        }

    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != head);
        System.out.println("Null");
    }

}

public class Demo {
    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.insertAtBegin(4);
        cl.insertAtBegin(3);
        cl.insertAtBegin(2);
        cl.insertAtBegin(1);
        cl.insertAtEnd(5);
        // cl.insertAtpos(1, 0);
        // cl.delteAtBegin();
        // cl.delteAtEnd();
        cl.delteAtpos(5);
        cl.display();
    }
}
