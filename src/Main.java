import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList  q = new LinkedList();
        System.out.println(q);
        q.add(0, "dfdfg");
        System.out.println(q);

        System.out.println(q.size());

        MyLinkedList a = new MyLinkedList();
        a.addFirst("jhj");
        System.out.println(a.size());
        System.out.println(q.remove(0));
        a.addLast(5654);
        a.addLast(54);
        a.addLast(56);
        System.out.println(a);
    }
}
