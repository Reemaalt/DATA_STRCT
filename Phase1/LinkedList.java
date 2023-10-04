import java.util.List;
public class LinkedList <T> implements List <T> {
  
private Node <T> head ;
private Node <T> current ;


  public boolean isEmpty() {
        return head == null;
    }
//adding Contact to contactList
public void Add (T contact){
Node <T> tmp = new Node <T> (contact) ;

 if (isEmpty()){
      head = tmp ; }
 else {
    current = head ;
    while (current.next != null){
        current = current.next;
    }
    current.next = tmp ;

 }
}

 //adding event to eventList 
public void Add (T Event){
Node <T> tmp = new Node <T> (Event) ;
//chake befor
 if (isEmpty()){
      head = tmp ; }
 else {
    current = head ;
    while (current.next != null){
        current = current.next;
    }
    current.next = tmp ;
 }
}


//delete Contact 
//idk how to make it delete the the event list within it :)
public boolean Delete (T contact){
    if ( isEmpty() )
         return false ;
    else if (head.data.equals(contact)){
        head = head.next ;
      return true;
    }
    else {
        Node<T> previous = null ;
        current = head.next;
    
        while (current != null && !current.data.equals(contact)){
            previous = current;
            current = current.next;
        }
    
        if (current == null){
        return false ;
        }
    
     current = current.next ;   
    previous.next = current ;
      return true ;
    }
    }

    public boolean contains(Contact contact) {
       current = head;
        while (current != null) {
            if (current.data.equalsIgnoreCase(contact)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

}
//public T [] Search (String nContact ){}
}

