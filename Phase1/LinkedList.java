public class LinkedList <T> implements List<T> {
  
private Node <T> head ;
private Node <T> current ;

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

public T [] Search (String nContact ){

}


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
