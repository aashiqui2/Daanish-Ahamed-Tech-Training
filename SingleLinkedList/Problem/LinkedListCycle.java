class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    public void insertAtBegin(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }

    public Node connectnode(int pos) {
        if (head == null) {
            System.out.println("Unable to connect");
            return null;
        }
        Node temp = head;
        int length = 0;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        if (pos > length) {
            System.out.println("Unable to connect");
            return null;
        }

        Node pair = head;
        for (int i = 0; i < pos; i++) {
            pair = pair.next;
        }

        temp.next = pair;
        return head;
    }

    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        int count = 0;
        while (temp != null && count < 10) { 
            System.out.print(temp.data + "->");
            temp = temp.next;
            count++;
        }
        System.out.println("Null");
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtBegin(-4);
        ll.insertAtBegin(0);
        ll.insertAtBegin(2);
        ll.insertAtBegin(3);
        Node head = ll.connectnode(1);
        if (ll.hasCycle(head)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        ll.display();
    }
}
