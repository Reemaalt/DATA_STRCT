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

}


}
