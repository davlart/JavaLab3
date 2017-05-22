package humanResources;

/**
 * Created by ArthurArt on 06.05.2017.
 */
public class LinkedCyclingList<T> {
    private Node head;
    private Node current;
    private Node tail;
    private int size ;
    public LinkedCyclingList(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void add(T value){
        size++;
        Node temp = new Node(value);

        if(head!= null){
            tail.next = temp;
            tail = temp;
        }
        else {head=tail=temp; }
        temp.setNext(head);
    }

    public void addAll(T[] array){
        for(T a: array)
            add(a);
            }
    public int count(){
        return size;
    }

    public void delete(T value){
        Node temp = head;
        Node prew = tail;

        while(true){
            if(temp.getValue().equals(value)){
                if(temp == head) head = temp.getNext();
                if(temp == tail) tail = prew;
                prew.setNext(temp.getNext());
                size--;
                break;
            }
            if(temp == tail ) break;
           temp = temp.getNext();
           prew = prew.getNext();
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

        Node(Node next,T value){
            this.next = next;
            this.value = value;
        }
        Node(T value){
            this(null, value);

        }


        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
        public T getValue(){
            return value;
        }
                  public  void setValue(T value){
            this.value = value;
                  }
    }





}
