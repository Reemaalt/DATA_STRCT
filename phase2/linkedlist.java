package phase2;


public class linkedlist <T>  {
  
private nodeLL<T> head ;
private nodeLL<T> current ;
 private nodeLL<T> previous;
//public Object getData;

// Getter and setter methods for the fields
public nodeLL<T> getHead() {
    return head;
}

public void setHead(nodeLL<T> head) {
    this.head = head;
}

public nodeLL<T> getCurrent() {
    return current;
}

public void setCurrent(nodeLL<T> current) {
    this.current = current;
}

//chaking if the list is empty
public boolean isEmpty() {
        return head == null;
}

public void AddContact(String contactname) {
nodeLL<T> contactInEvent = new nodeLL<T>((T) contactname);
     
    if (isEmpty()) {
            head = contactInEvent;
            System.out.println("Contact added successfully.");
    }
    else {
            current = head;
        while (current.next != null) {
                current = current.next;
        }
            current.next = contactInEvent;
            System.out.println("Contact added successfully.");
    }    
}

public void Add (Events val) {
    nodeLL<Events> tmp = new nodeLL<Events>(val);

    if (isEmpty() || head.compareTo(tmp)>=0 ) {
        tmp.next=(nodeLL<Events>) head;
        head=(nodeLL<T>) tmp;
    
    } else {
        current = head;
        while (current.getNext() != null && current.getNext().compareTo(tmp)<0) {
            current = current.getNext();
        }
        tmp.setNext((nodeLL<Events>) current.getNext()); 
        current.setNext(( nodeLL<T>)tmp);
    }
}


public void DeleteContact ( String contact){
   
    
    if ( isEmpty() )
        System.out.println("no events to delete");
        
    else if (head.equals(contact)){
        head = head.getNext() ;
        System.out.println("Contact deleted successfully.");
    }
    else {
        // previous = null ;
     current = getHead().getNext();
    
            while (current != null && !current.data.equals(contact)){
            previous = current;
            current = current.next;
            }
    
    if (current == null){
        System.out.println("this Contact is not on the list of this event");

    }
    
        previous.next = current.next;
        System.out.println("Contact deleted successfully.");

    }
 
    }
    
}
