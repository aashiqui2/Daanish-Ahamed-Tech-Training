public class BubbleSortLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void bubbleSort() {
        if (head == null) return;

        int n = getListLength();

        for (int i = 0; i < n - 1; i++) {
            Node current = head;
            Node next = head.next;

            for (int j = 0; j < n - i - 1; j++) {
                if (current.data > next.data) {
                    // Swap the data
                    int temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                current = next;
                next = next.next;
            }
        }
    }

    private int getListLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void main(String[] args) {
        BubbleSortLinkedList list = new BubbleSortLinkedList();

        list.insert(4);
        list.insert(2);
        list.insert(1);
        list.insert(3);

        System.out.println("Original Linked List:");
        list.display();

        list.bubbleSort();

        System.out.println("Sorted Linked List:");
        list.display();
    }
}
