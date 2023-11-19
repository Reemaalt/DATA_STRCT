package phase2;
public class linkedlist <T> {
  
private nodeLL<T> head ;
private nodeLL<T> current ;
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
nodeLL<T> contactinevent = new nodeLL<T>();
     
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

public void Add (T val) {
    nodeLL<T> tmp = new nodeLL<T>(val);

    if (isEmpty()) {
        current = head = tmp;
    } else {
        current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(tmp);
    }
}


}
