public class Node<T> { 
        public T data; 
        public Node<T> next;
public Node () { 
    data = null; 
    next = null;
}
public Node (T val) {
    data = val;
    next = null; 
}

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
 


    // Fields for the event data and the next node reference
    private Event event;


    // Constructor that takes the event data as a parameter
    public Node(Event event) {
        this.event = event;
        this.next = null;
    }

    // Getter and setter methods for the fields
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

   
    }
