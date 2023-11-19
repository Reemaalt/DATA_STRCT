package phase2;

import java.time.LocalDateTime;

public class Events {

// Fields for the event 
private String title;
private LocalDateTime dateTime;
private String location;
private String Contact; 
private Contact contact2;
private  linkedlist <String> involedContacts ;
private boolean isAppointment;


// Constructor  for the events
public Events(String title, LocalDateTime dateTime, String location , boolean isAppointment,String Contact , Contact contact2) {
        this.title = title;
        this.dateTime = dateTime;
        this.location = location;

       if( isAppointment)
       {
        this.contact2=contact2;
       }
       else{
       involedContacts = new linkedlist<String>();
        String[] names = Contact.split("\\s*,\\s*"); // Split names by comma and trim spaces
        for (int i = 0; i < names.length; i++) {
            involedContacts.AddContact(names[i]);
        }
    }
}

//add to involedContacts string 
public void AddtoInvoledContacts ( linkedlist <String> involedContacts , String Contact ){
    if (involedContacts.isEmpty()) {

        involedContacts.head= Contact;
        System.out.println("Contact added successfully.");
    }
    else {
        involedContacts.current = involedContacts.head;

        while (involedContacts.current.getNext() != null) {
        involedContacts.current = involedContacts.current.setNext();
        }
        involedContacts.current.setNext(Contact);
        System.out.println("Contact added successfully.");
    }    
}

//delete the contact name involedContacts
public void DeleteContact ( linkedlist <String> involedContacts, String contact){
    
    if ( involedContacts.isEmpty() )
        System.out.println("no events to delete");
        
    else if (involedContacts.head.equals(contact)){
        involedContacts.head = involedContacts.head.getNext() ;
        System.out.println("Contact deleted successfully.");
    }
    else {
        nodeLL<String> previous = null ;
        involedContacts.current = involedContacts.getHead().getNext();
    
            while (involedContacts.current != null && !involedContacts.current.data.equals(contact)){
            previous = current;
            current = current.next;
            }
    
    if (involedContacts.current == null){
        System.out.println("this Contact is not on the list of this event");

    }
    
        involedContacts.previous.next = involedContacts.current.next;
        System.out.println("Contact deleted successfully.");

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

   public String getContact() {
    return Contact;
    }

public void setContact(String contact) {
    Contact = contact;
    }

public Contact getContact2() {
    return contact2;
    }

public void setContact2(Contact contact2) {
    this.contact2 = contact2;
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
