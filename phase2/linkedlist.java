package phase2;
public class linkedlist <T> {
  
private nodeLL<String> head ;
private nodeLL<String> current ;
//public Object getData;

// Getter and setter methods for the fields
public nodeLL<String> getHead() {
    return head;
}

public void setHead(nodeLL<String> head) {
    this.head = head;
}

public nodeLL<String> getCurrent() {
    return current;
}

public void setCurrent(nodeLL<String> current) {
    this.current = current;
}

//chaking if the list is empty
public boolean isEmpty() {
        return head == null;
}

public void AddContact(String contactname) {
nodeLL<String> contactinevent = new nodeLL<String>(contactname);
     
    if (isEmpty()) {
            head = contactinevent;
            System.out.println("Contact added successfully.");
    }
    else {
            current = head;
        while (current.next != null) {
                current = current.next;
        }
            current.next = contactinevent;
            System.out.println("Contact added successfully.");
    }    
}

}
