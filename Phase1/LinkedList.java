import java.util.List;
public class LinkedList <T> implements List <T> {
  
private Node <T> head ;
private Node <T> current ;

//adding Contact to contactList
public void Add (T contact){
Node <T> tmp = new Node <T> (contact) ;

 if (head == null){
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

 if (head == null){
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
public void Delete (T contact){
    if ( head == null )
         return;
    else if (head.data.equals(contact)){
        head = head.next ;
    }
    else {
        Node<T> previous = null ;
        current = head.next;
    
        while (current != null && !current.data.equals(contact)){
            previous = current;
            current = current.next;
    
        }
    
        if (current == null)
        return ;
    
     current = current.next ;   
    previous.next = current ;
    }
    }
    

//public T [] Search (String nContact ){}
}

