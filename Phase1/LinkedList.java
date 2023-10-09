/*-LinkedList ADT: This class will represent the linked list data structure used to store the contacts.
It should have methods for adding, searching, and deleting contacts from the list */
import java.util.List;

public class LinkedList <T> {
  
private Node <T> head ;
public void setHead(Node<T> head) {
    this.head = head;
}

public Node<T> getHead() {
    return head;
}

private Node <T> current ;
public Object getData;

//chaking if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

//adding Contact to contactList
    public void AddContact (T contact){
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
// Make sure before adding an event that the contact in the event exist in the contact list
    public void AddEvent (Event event){
Node <T> tmp = new Node <T> () ;
if(!contains(null)){
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
}

//delete Contact 
//When a contact is deleted all events with that contact are also deleted.)
    public boolean DeleteContact (T contact){
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

    public boolean hasNext (){
     return current != null;
    }
//exist in the list
//Make sure before adding an event that the contact in the event exist in the contact list.
    public boolean contains(Contact othercontact) {
       current = head;
        while (current != null) {
            if ( (current.data) == (othercontact.data) ) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean startsWith (String name , String searchName ){
        if (name.length() != searchName.length()) {
        return false ;
        }
        
        for (int i =0 ; i< searchName.length() ; i++){
            if (name.charAt(i) != searchName.charAt (i))
            return false;
        }

        return true ;
    }
   
}
//method we need to do!!!!!
//has the event 
