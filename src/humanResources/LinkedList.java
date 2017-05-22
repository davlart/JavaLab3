package humanResources;

/**
 * Created by Oris on 30.04.2017.
 */
public class LinkedList<T> {
    private Node head;
    private Node tail;
    private Node current;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value){
        size++;
        Node temp = new Node(value);
        if(head!=null){
            tail.setNext(temp);
            tail = temp;
        }else{
            head=tail=temp;
        }
    }

    public void addAll(T[] array){
        for(T a : array){
            add(a);
        }
    }

    public int count(){
        return size;
    }

    public boolean delete(T value){
        Node temp = head;
        Node prev = tail;
        while(true){
            if(temp.getValue().equals(value)){

                if(temp==head) head = temp.getNext();
                if(temp==tail)  tail = prev;
                prev.setNext(temp.getNext());
                size--;
                return true;
            }
            if(temp == tail) return false;
            temp = temp.getNext();
            prev = prev.getNext();
        }
    }

    public T next(){
        if(current == null) current = head;
        else current = current.getNext();
        return current.getValue();
    }

    public void reset(){
        current = null;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        Node node = head;
        for(int i=0; i<size; i++){
            hash ^= node.getValue().hashCode();
            node = node.getNext();
        }
        return hash;
    }

    class Node{
        Node next;
        T value;

        public Node(Node nextNode, T value){
            this.next = nextNode;
            this.value = value;
        }

        public Node(T value){
            this(null,value);
        }

        public Node getNext() {
            return next;
        }



        public void setNext(Node next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
