package SingleLinkedList;
class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

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
        } else {
            newnode.next = head;
            head = newnode;

        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("Null");
        }
    }

    public void insertAtEnd(int val)

    {
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

    public void deleteAtBegin() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            Node prev = null;

            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }
    }

    public void insertAtpos(int pos, int val) {

        if (pos == 0) {
            insertAtBegin(val);
            return;
        }
        Node newnode=new Node(val);
        if (head == null) {
            System.out.println("Unable to insert List is empty");
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
                if (temp == null) {
                    System.out.println("Unable to insert");
                    return;
                }
            }
            if (temp == null) {
                System.out.println("Unable to insert");
                return;
            }
           newnode.next=temp.next;
           temp.next=newnode;

        }
    }
    public void deleteAtpos(int pos)
    {
        if(pos==0)
        {
            deleteAtBegin();
            return;
        }
        if(head==null)
        {
            System.out.println("NOthing to delete List is empty");
            return;
        }
        else{
            Node temp=head;
            Node prev=null;
            for(int i=0;i<pos;i++)
            {
                prev=temp;
                temp=temp.next;
                if(temp==null)
                {
                    System.out.println("Position invalid");
                    return;
                }
            }
            prev.next=temp.next;
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtBegin(3);
        ll.insertAtBegin(2);
        ll.insertAtBegin(1);
        ll.insertAtEnd(4);
        ll.deleteAtBegin();
        ll.deleteAtEnd();
        ll.insertAtpos(3, 1);
        ll.deleteAtpos(2);
        ll.display();
    }

}