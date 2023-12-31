/*-LinkedList ADT: This class will represent the linked list data structure used to store the contacts.
It should have methods for adding, searching, and deleting contacts from the list */
public class LinkedList <T> {
  
private Node <T> head ;
private Node <T> current ;
//public Object getData;

// Getter and setter methods for the fields
    public void setHead(Node<T> head) {
    this.head = head;
}

    public Node<T> getHead() {
    return head;
}

//chaking if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

//adding Contact to contactList

public void AddContact(Contact contact) {
    Node<T> newNode = new Node<T>((T) contact);

    if (!contains(contact.getPhoneNumber()) || !containsName(contact)) {
        if (isEmpty()) {
            head = newNode;
        } else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
       // System.out.println("Contact added successfully.");
    } else {
        System.out.println("Contact with the same name or phone number already exists.");
    }
}

public boolean containsName(Contact contact) {
    current = head;
    while (current != null) {
        if (((Contact) current.data).compareTo(contact) == 0) {
            return true;
        }
        current = current.next;
    }
    return false;
}

public boolean contains(String phoneNumber) {
    current = head;
    while (current != null) {
        if (((Contact) current.data).getPhoneNumber().equals(phoneNumber)) {
            return true;
        }
        current = current.next;
    }
    return false;
}


 
// Make sure before adding an event that the contact in the event exist in the contact list
    public void AddEvent (Event event){
    Node <Event> tmp = new Node <Event> (event) ;
  
if (isEmpty()){
       head =  (Node<T>) tmp ; 
      //System.out.println("Event scheduled successfully.");
    }
 else {
    current = head ;
    while (current.next != null){
        current = current.next;

    }
     current.next =   (Node<T>) tmp ;
 //System.out.println("Event scheduled successfully.");
}
}

//delete Contact 
//When a contact is deleted all events with that contact are also deleted.
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
    
        previous.next = current.next;
     
      return true ;
    }
 
    }

    public boolean hasTheEvent(Event targetEvent) {
        if (isEmpty() )
        return false ;
    Node <Contact> tmp = new Node <Contact> () ;
        tmp=(Node<Contact>) head;
         while(tmp!= null) {
             Node <Event> tem = new Node <Event> () ;
            tem= tmp.getData().getEvents().getHead();
             while(tem!= null) {
             if (tem.getData().compareTo(targetEvent) == 0) {
                        return true;
                    }
                    tem = tem.getNext();
                }
                tmp = tmp.getNext(); 
                 
            
         } return false; }
    

//exist in the list
    public boolean hasNext (){
     return current != null;
     
    }

  

    public boolean startsWith(String name, String searchName) {
        return name.contains(searchName);
    }
    
   

}

