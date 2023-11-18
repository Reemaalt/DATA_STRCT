package phase2;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Events {

// Fields for the event 
private String title;
private LocalDateTime dateTime;
private String location;
private String Contact; 
private  LinkedList <Contact> involedContacts ;
private boolean isAppointment;




// Constructor 1 for the events
public Events(String title, LocalDateTime dateTime, String location , boolean isAppointment,String Contact) {
        this.title = title;
        this.dateTime = dateTime;
        this.location = location;
       if( isAppointment)
     {this.Contact=Contact;
      
     }
else{
        involedContacts = new LinkedList<Contact>();
                involedContacts.add(Contact);

}
}
//+1

public void AddContact(String contactname) {
    Node<String> newNode = new Node<String>((Contact) contact);
     if (isAppointment() && involedContacts.size()==0)
     {
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


// Getter and setter methods for the fields
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime( LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Contact getContact() {
        return Contact;
    }

    public void setContact(Contact contact) {
        this.Contact = contact;
    }
    

public boolean isAppointment() {
    return isAppointment;
}


public void setAppointment(boolean isAppointment) {
    this.isAppointment = isAppointment;
}

    @Override
    public String toString() {
        return "Event title:" + title + ", event date and Time (MM/DD/YYYY HH:MM):" + dateTime + ", event location:" + location + ", Contact name:"//Contact.getname()
                ;
    }
    
}
