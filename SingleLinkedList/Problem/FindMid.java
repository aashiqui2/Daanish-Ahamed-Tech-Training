import java.util.LinkedList;

public class FindMid {
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.add(60);
        Integer middle=ll.size()/2;
        System.out.println(ll.get(middle));
    }
}
