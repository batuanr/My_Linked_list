import java.util.Arrays;

public class MyLinkedList<E> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;


    public MyLinkedList() {
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }
    class Node {
        private Node next;
        private Object data;


        public Node() {
        }



        public Node(Object data) {
            this.data = data;

        }

        public Object getData() {
            return data;
        }
    }
    public void add(int index, E e){
        if (index == 0){
            addFirst(e);
        }
        else{
            if (index == size -1){
                addLast(e);
            }
            else{
                Node temp = head;
                Node holder;
                for (int i = 0; i < index - 1 && temp.next != null; i++) {
                    temp = temp.next;
                }
                holder = temp.next;
                temp.next = new Node(e);
                temp.next.next = holder;
                size++;
            }
        }


    }
    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        size++;
        if (size == 1){
            tail = head;
        }
    }
    public void addLast(E data){
        if (size == 0){
            tail = head = new Node(data);
        }
        else{
            tail.next = new Node(data);
            tail = tail.next;
            size++;
        }
    }
    public int size(){
        return size;
    }
    public E get(int index){
        Node temp = head;
        for(int i=0; i< index ; i++) {
            temp = temp.next;
        }
        E data = (E) temp.data;
        return data;
    }
    public E remove(int index){
        Node removeNode;
        Node temp = head;
        if (index == 0){
            removeNode = head;
            head = head.next;
            size--;
            return (E)removeNode.data;
        }
        else{
            for (int i = 0; i < index - 1 && temp.next != null ; i++) {
                temp = temp.next;
            }
            removeNode = temp.next;
            temp.next = temp.next.next;
            size--;
            return (E)removeNode.data;
        }

    }
    public MyLinkedList clone(){
        Node temp = head;
        MyLinkedList newlist = new MyLinkedList();
        newlist.addFirst(temp.data);
        temp = temp.next;
        while (temp != null){
            newlist.addLast(temp.data);
            temp = temp.next;
        }
        return newlist;
    }
    public E getFirst(){
        E data = (E) head.data;
        return data;
    }
    public E getLast(){
        E data = (E) tail.data;
        return data;
    }
    public void clear(){
        head = tail = null;
        size = 0;
    }
    public int indexOf(Object o){
        Node temp = head;
        if (temp.data.equals(o)){
            return 0;
        }
        else {
            for (int i = 1; i < size-1; i++) {
                temp = temp.next;
                if (temp.data.equals(o)){
                    return i;
                }
            }
            return -1;
        }
    }
    public String toString(){
        if (size == 0){
            return "[]";
        }
        else{
            Object[] newStr = new Object[size];
            Node temp = head;
            newStr[0] = temp.data;
            for (int i = 0; i < size -1; i++) {
                temp = temp.next;
                newStr[i+1] = temp.data;
            }
            return Arrays.toString(newStr);
        }
    }
}
